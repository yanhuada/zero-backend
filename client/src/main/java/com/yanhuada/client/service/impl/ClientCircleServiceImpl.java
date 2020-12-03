package com.yanhuada.client.service.impl;

import com.yanhuada.client.dao.*;
import com.yanhuada.client.jwt.JwtSessionUtil;
import com.yanhuada.client.model.circle.CirclePoToDto;
import com.yanhuada.client.model.circle.req.CircleResourcePagerReq;
import com.yanhuada.client.model.circle.req.CircleTopicContentPagerReq;
import com.yanhuada.client.model.circle.req.CircleUserPagerReq;
import com.yanhuada.client.model.circle.rsp.*;
import com.yanhuada.client.service.ClientCircleService;
import com.yanhuada.client.service.ClientSystemMessageRecordService;
import com.yanhuada.client.service.ClientUserService;
import com.yanhuada.common.enumeration.PublishStatus;
import com.yanhuada.common.model.Pager;
import com.yanhuada.common.util.aliyun.oss.OssUtil;
import com.yanhuada.exception.CommonException;
import com.yanhuada.exception.ErrorCode;
import com.yanhuada.model.*;
import com.yanhuada.service.impl.BaseCircleServiceImpl;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yanhuada
 * CREATE ON 2020/8/21 17:40
 */
@Service
public class ClientCircleServiceImpl extends BaseCircleServiceImpl implements ClientCircleService {

    @Resource
    private ClientCircleMapper clientCircleMapper;
    @Resource
    private ClientCircleTopicMapper clientCircleTopicMapper;
    @Resource
    private ClientCircleTopicContentMapper clientCircleTopicContentMapper;
    @Resource
    private ClientCircleUserMapper clientCircleUserMapper;
    @Resource
    private ClientCircleResourceMapper clientCircleResourceMapper;
    @Resource
    private ClientSystemMessageRecordService clientSystemMessageRecordService;
    @Resource
    private OssUtil ossUtil;
    @Resource
    private JwtSessionUtil jwtSessionUtil;
    @Resource
    private HttpServletRequest request;
    @Resource
    private ClientUserService clientUserService;

    @Override
    public List<CircleListRsp> hotList() {

        List<Circle> circleList = clientCircleMapper.hotList();
        return circleList.stream()
                .map(circle -> CirclePoToDto.copyCircleListRsp(circle, ossUtil))
                .collect(Collectors.toList());
    }

    @Override
    public List<CircleListRsp> mineList() {
        if (jwtSessionUtil.ifAnonymous(request)) {
            return new ArrayList<>();
        }

        List<Long> circleIdList = this.getUserCircleIdList();
        if (CollectionUtils.isEmpty(circleIdList)) {
            return new ArrayList<>();
        }

        CircleExample circleExample = new CircleExample();
        circleExample.createCriteria().andIdIn(circleIdList).andIfEnableEqualTo(true);

        List<Circle> circleList = clientCircleMapper.selectByExample(circleExample);

        return circleList.stream()
                .map(circle -> CirclePoToDto.copyCircleListRsp(circle, ossUtil))
                .collect(Collectors.toList());
    }

    @Override
    public List<CircleListRsp> otherList() {
        CircleExample example = new CircleExample();
        CircleExample.Criteria criteria = example.createCriteria();
        criteria.andIfEnableEqualTo(true);

        if (!jwtSessionUtil.ifAnonymous(request)) {
            List<Long> circleIdList = this.getUserCircleIdList();
            if (CollectionUtils.isNotEmpty(circleIdList)) {
                criteria.andIdNotIn(circleIdList);
            }
        }
        example.setOrderByClause("id");

        List<Circle> circleList = clientCircleMapper.selectByExample(example);

        return circleList.stream()
                .map(circle -> CirclePoToDto.copyCircleListRsp(circle, ossUtil))
                .collect(Collectors.toList());
    }

    @Override
    public CircleDetailRsp detail(Long id) {
        Circle circle = super.findByIdOrFail(id);
        Boolean ifJoin = !jwtSessionUtil.ifAnonymous(request) &&
                super.ifJoin(jwtSessionUtil.getUserIdFromAuthenticatedSession(request), circle.getId());

        return CirclePoToDto.copyCircleDetailRsp(circle, ifJoin, false, ossUtil);
    }


    @Override
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void join(Long id) {
        Long userId = jwtSessionUtil.getUserIdFromAuthenticatedSession(request);
        User user = clientUserService.findByIdFail(userId);
        Circle circle = super.findByIdOrFail(id);

        if (super.ifJoin(user.getId(), circle.getId())) {
            throw new CommonException(ErrorCode.CIRCLE_USER_EXISTS);
        }

        CircleUser circleUserForAdd = new CircleUser();
        circleUserForAdd.setUserId(user.getId());
        circleUserForAdd.setUserNickname(user.getNickname());
        circleUserForAdd.setUserAvatar(user.getAvatar());

        circleUserForAdd.setCircleId(circle.getId());
        circleUserForAdd.setCircleName(circle.getName());
        circleUserForAdd.setCircleIcon(circle.getIcon());
        circleUserForAdd.setCircleUserNum(circle.getUserNum());

        clientCircleUserMapper.insertSelective(circleUserForAdd);

        //增加圈子的用户数量
        super.addUserNum(circle);

        //推送信息
        clientSystemMessageRecordService.sendJoinCircleMessage(user, circle);
    }

    @Override
    public List<CircleTopicListRsp> topicList(Long circleId) {

        CircleTopicExample example = new CircleTopicExample();
        example.createCriteria()
                .andCircleIdEqualTo(circleId)
                .andPublishStatusEqualTo(PublishStatus.PUBLISHED.getCode());
        example.setOrderByClause("sort desc");

        List<CircleTopic> circleTopicList = clientCircleTopicMapper.selectByExample(example);
        return circleTopicList.stream().map(CirclePoToDto::copyCircleTopicListRsp).collect(Collectors.toList());
    }

    @Override
    public Pager<CircleTopicContentPagerRsp> topicContentPagination(CircleTopicContentPagerReq req) {
        Pager<CircleTopicContentPagerRsp> rspPager = new Pager<>(req.getPage(), req.getCount());
        Long total = clientCircleTopicContentMapper.total(req.getCircleTopicId());
        rspPager.setTotal(Math.toIntExact(total));
        if (total == 0) {
            return rspPager;
        }
        List<CircleTopicContent> circleTopicContentList = clientCircleTopicContentMapper.list(req.getCircleTopicId(), req);
        rspPager.setArray(circleTopicContentList.stream()
                .map(CirclePoToDto::copyCircleTopicContentPagerRsp)
                .collect(Collectors.toList()));
        return rspPager;
    }

    @Override
    public CircleTopicContentDetailRsp topicContentDetail(Long topicContentId) {
        CircleTopicContent circleTopicContent = super.findTopicContentByIdOrFail(topicContentId);

        return CirclePoToDto.copyCircleTopicContentDetailRsp(circleTopicContent);
    }

    @Override
    public Pager<CircleResourcePagerRsp> resourcePagination(CircleResourcePagerReq req) {
        Pager<CircleResourcePagerRsp> rspPager = new Pager<>(req.getPage(), req.getCount());
        Long total = clientCircleResourceMapper.total(req.getCircleId());
        rspPager.setTotal(Math.toIntExact(total));
        if (total == 0) {
            return rspPager;
        }
        List<CircleResource> circleResourceList = clientCircleResourceMapper.list(req.getCircleId(), req);
        rspPager.setArray(circleResourceList.stream()
                .map(CirclePoToDto::copyCircleResourcePagerRsp)
                .collect(Collectors.toList()));
        return rspPager;
    }

    @Override
    public CircleResourceDetailRsp resourceDetail(Long id) {
        CircleResource circleResource = super.findResourceByIdOrFail(id);
        return CirclePoToDto.copyCircleResourceDetailRsp(circleResource);
    }

    @Override
    public Pager<CircleUserListRsp> userPagination(CircleUserPagerReq req) {
        Pager<CircleUserListRsp> rspPager = new Pager<>(req.getPage(), req.getCount());
        Long total = clientCircleUserMapper.total(req.getCircleId());
        rspPager.setTotal(Math.toIntExact(total));
        if (total == 0) {
            return rspPager;
        }
        List<CircleUser> circleUserList = clientCircleUserMapper.list(req.getCircleId(), req);
        rspPager.setArray(circleUserList.stream()
                .map(circleUser -> CirclePoToDto.copyCircleUserListRsp(circleUser, ossUtil))
                .collect(Collectors.toList()));
        return rspPager;
    }

    private List<Long> getUserCircleIdList() {
        Long userId = jwtSessionUtil.getUserIdFromAuthenticatedSession(request);
        CircleUserExample circleUserExample = new CircleUserExample();
        circleUserExample.createCriteria().andUserIdEqualTo(userId);
        return clientCircleUserMapper
                .selectByExample(circleUserExample)
                .stream()
                .map(CircleUser::getCircleId)
                .collect(Collectors.toList());
    }
}
