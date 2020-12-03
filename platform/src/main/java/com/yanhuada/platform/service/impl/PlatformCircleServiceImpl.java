package com.yanhuada.platform.service.impl;

import com.yanhuada.common.enumeration.PublishStatus;
import com.yanhuada.common.model.Pager;
import com.yanhuada.common.util.aliyun.oss.OssUtil;
import com.yanhuada.exception.CommonException;
import com.yanhuada.exception.ErrorCode;
import com.yanhuada.model.Circle;
import com.yanhuada.model.CircleResource;
import com.yanhuada.model.CircleTopic;
import com.yanhuada.model.CircleTopicContent;
import com.yanhuada.platform.dao.PlatformCircleMapper;
import com.yanhuada.platform.dao.PlatformCircleResourceMapper;
import com.yanhuada.platform.dao.PlatformCircleTopicContentMapper;
import com.yanhuada.platform.dao.PlatformCircleTopicMapper;
import com.yanhuada.platform.model.circle.CirclePoToDto;
import com.yanhuada.platform.model.circle.req.CirclePagerReq;
import com.yanhuada.platform.model.circle.req.CircleResourcePagerReq;
import com.yanhuada.platform.model.circle.req.CircleTopicContentPagerReq;
import com.yanhuada.platform.model.circle.rsp.*;
import com.yanhuada.platform.service.PlatformCircleService;
import com.yanhuada.service.impl.BaseCircleServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yanhuada
 * CREATE ON 2020/8/12 18:09
 */
@Service
public class PlatformCircleServiceImpl extends BaseCircleServiceImpl implements PlatformCircleService {

    @Resource
    private PlatformCircleMapper platformCircleMapper;
    @Resource
    private PlatformCircleTopicMapper platformCircleTopicMapper;
    @Resource
    private PlatformCircleTopicContentMapper platformCircleTopicContentMapper;
    @Resource
    private PlatformCircleResourceMapper platformCircleResourceMapper;
    @Resource
    private OssUtil ossUtil;

    @Override
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void add(String name, String icon, String cover, String introduce) {
        Circle circle = platformCircleMapper.findByName(name);
        if (circle != null) {
            throw new CommonException(ErrorCode.CIRCLE_NAME_USED);
        }
        Circle circleForAdd = new Circle();
        circleForAdd.setName(name);
        circleForAdd.setIcon(icon);
        circleForAdd.setCover(cover);
        circleForAdd.setIntroduce(introduce);
        platformCircleMapper.insertSelective(circleForAdd);
    }

    @Override
    public Pager<CirclePagerRsp> pagination(CirclePagerReq req) {
        Pager<CirclePagerRsp> rspPager = new Pager<>(req.getPage(), req.getCount());
        Long total = platformCircleMapper.total(req.getName(), req.getIfEnable());
        rspPager.setTotal(Math.toIntExact(total));
        if (total == 0) {
            return rspPager;
        }
        List<Circle> circleList = platformCircleMapper.list(req.getName(), req.getIfEnable(), req);
        rspPager.setArray(circleList.stream()
                .map(item -> CirclePoToDto.copyCirclePagerRsp(item, ossUtil))
                .collect(Collectors.toList()));
        return rspPager;
    }

    @Override
    public List<CirclePagerRsp> list(String name) {
        List<Circle> circleList = platformCircleMapper.list(name, null, null);
        return circleList.stream()
                .map(item -> CirclePoToDto.copyCirclePagerRsp(item, ossUtil))
                .collect(Collectors.toList());
    }

    @Override
    public CircleDetailRsp detail(Long id) {
        Circle circleForDetail = super.findByIdOrFail(id);
        return CirclePoToDto.copyCircleDetailRsp(circleForDetail);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void topicAdd(Long circleId, String name, Integer sort) {
        Circle circle = super.findByIdOrFail(circleId);
        CircleTopic circleTopic = platformCircleTopicMapper.findByName(circleId, name);
        if (circleTopic != null) {
            throw new CommonException(ErrorCode.CIRCLE_TOPIC_NAME_USED);
        }
        CircleTopic circleTopicForAdd = new CircleTopic();
        circleTopicForAdd.setCircleId(circle.getId());
        circleTopicForAdd.setName(name);
        circleTopicForAdd.setPublishStatus(PublishStatus.UNPUBLISHED.getCode());
        platformCircleTopicMapper.insertSelective(circleTopicForAdd);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void topicUpdate(Long id, String name, Integer sort) {
        CircleTopic circleTopicForUpdate = super.findTopicByIdOrFail(id);
        if (!StringUtils.equals(name, circleTopicForUpdate.getName()) && platformCircleTopicMapper.findByName(circleTopicForUpdate.getCircleId(), name) != null) {
            throw new CommonException(ErrorCode.CIRCLE_TOPIC_NAME_USED);
        }
        circleTopicForUpdate.setName(name);
        circleTopicForUpdate.setSort(sort);
        platformCircleTopicMapper.updateByPrimaryKeySelective(circleTopicForUpdate);
    }

    @Override
    public List<CircleTopicListRsp> topicList(Long circleId, String name, Integer publishStatus) {
        List<CircleTopic> circleTopicList = platformCircleTopicMapper.list(circleId, name, publishStatus);
        return circleTopicList.stream()
                .map(circleTopic -> CirclePoToDto.copyCircleTopicListRsp(circleTopic, super.findByIdOrFail(circleTopic.getCircleId())))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void topicContentAdd(Long circleTopicId, String author, String title, String content) {
        CircleTopic circleTopic = super.findTopicByIdOrFail(circleTopicId);

        CircleTopicContent circleTopicContentForAdd = new CircleTopicContent();
        circleTopicContentForAdd.setCircleTopicId(circleTopic.getId());
        circleTopicContentForAdd.setAuthor(author);
        circleTopicContentForAdd.setTitle(title);
        circleTopicContentForAdd.setContent(content);
        circleTopicContentForAdd.setPublishStatus(PublishStatus.UNPUBLISHED.getCode());

        platformCircleTopicContentMapper.insertSelective(circleTopicContentForAdd);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void topicContentUpdate(Long id, String author, String title, String content) {
        CircleTopicContent circleTopicContentForUpdate = super.findTopicContentByIdOrFail(id);

        circleTopicContentForUpdate.setAuthor(author);
        circleTopicContentForUpdate.setTitle(title);
        circleTopicContentForUpdate.setContent(content);

        platformCircleTopicContentMapper.updateByPrimaryKeySelective(circleTopicContentForUpdate);
    }

    @Override
    public Pager<CircleTopicContentPagerRsp> topicContentPagination(CircleTopicContentPagerReq req) {
        Pager<CircleTopicContentPagerRsp> rspPager = new Pager<>(req.getPage(), req.getCount());

        Long total = platformCircleTopicContentMapper.total(req.getCircleId(), req.getCircleTopicId(),
                req.getAuthor(), req.getTitle(), req.getPublishStatus());

        rspPager.setTotal(Math.toIntExact(total));
        if (total == 0) {
            return rspPager;
        }
        List<CircleTopicContent> circleList = platformCircleTopicContentMapper.list(req.getCircleId(),
                req.getCircleTopicId(), req.getAuthor(), req.getTitle(), req.getPublishStatus(), req);

        rspPager.setArray(circleList.stream()
                .map(circleTopicContent -> {
                    CircleTopic circleTopic = super.findTopicByIdOrFail(circleTopicContent.getCircleTopicId());
                    Circle circle = super.findByIdOrFail(circleTopic.getCircleId());
                    return CirclePoToDto.copyCircleTopicContentPagerRsp(circleTopicContent, circleTopic, circle);
                })
                .collect(Collectors.toList()));

        return rspPager;
    }

    @Override
    public CircleTopicContentDetailRsp topicContentDetail(Long id) {
        CircleTopicContent circleTopicContent = super.findTopicContentByIdOrFail(id);
        CircleTopic circleTopic = super.findTopicByIdOrFail(circleTopicContent.getCircleTopicId());
        Circle circle = super.findByIdOrFail(circleTopic.getCircleId());
        return CirclePoToDto.copyCircleTopicContentDetailRsp(circleTopicContent, circleTopic, circle);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void enable(Long id, Boolean ifEnable) {
        Circle circle = super.findByIdOrFail(id);
        circle.setIfEnable(ifEnable);
        platformCircleMapper.updateByPrimaryKeySelective(circle);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void topicEnable(Long id, Boolean ifEnable) {
        CircleTopic circleTopic = super.findTopicByIdOrFail(id);
        if (ifEnable) {
            circleTopic.setPublishStatus(PublishStatus.PUBLISHED.getCode());
            circleTopic.setPublishTime(LocalDateTime.now());
        } else {
            circleTopic.setPublishStatus(PublishStatus.OFF.getCode());
        }
        platformCircleTopicMapper.updateByPrimaryKeySelective(circleTopic);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void topicContentEnable(Long id, Boolean ifEnable) {
        CircleTopicContent circleTopicContent = super.findTopicContentByIdOrFail(id);
        if (ifEnable) {
            circleTopicContent.setPublishStatus(PublishStatus.PUBLISHED.getCode());
            circleTopicContent.setPublishTime(LocalDateTime.now());
        } else {
            circleTopicContent.setPublishStatus(PublishStatus.OFF.getCode());
        }
        platformCircleTopicContentMapper.updateByPrimaryKeySelective(circleTopicContent);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void resourceAdd(Long circleId, String title, Boolean ifEnable, String content) {

        Circle circle = super.findByIdOrFail(circleId);
        CircleResource circleResourceForAdd = new CircleResource();
        circleResourceForAdd.setCircleId(circle.getId());
        circleResourceForAdd.setTitle(title);
        circleResourceForAdd.setIfEnable(ifEnable);
        circleResourceForAdd.setContent(content);

        platformCircleResourceMapper.insertSelective(circleResourceForAdd);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void resourceUpdate(Long id, String title, Boolean ifEnable, String content) {

        CircleResource circleResourceForUpdate = super.findResourceByIdOrFail(id);

        circleResourceForUpdate.setTitle(title);
        circleResourceForUpdate.setIfEnable(ifEnable);
        circleResourceForUpdate.setContent(content);

        platformCircleResourceMapper.updateByPrimaryKeySelective(circleResourceForUpdate);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void resourceEnable(Long id, Boolean ifEnable) {
        CircleResource circleResourceForUpdate = super.findResourceByIdOrFail(id);
        circleResourceForUpdate.setIfEnable(ifEnable);
        platformCircleResourceMapper.updateByPrimaryKeySelective(circleResourceForUpdate);
    }

    @Override
    public Pager<CircleResourcePagerRsp> resourcePagination(CircleResourcePagerReq req) {
        Pager<CircleResourcePagerRsp> rspPager = new Pager<>(req.getPage(), req.getCount());

        Long total = platformCircleResourceMapper.total(req.getCircleId(), req.getTitle(), req.getIfEnable());

        rspPager.setTotal(Math.toIntExact(total));
        if (total == 0) {
            return rspPager;
        }

        List<CircleResource> circleResourceList = platformCircleResourceMapper.list(req.getCircleId(), req.getTitle(), req.getIfEnable(), req);
        List<CircleResourcePagerRsp> rspList = circleResourceList
                .stream()
                .map(circleResource -> {
                    Circle circle = super.findByIdOrFail(circleResource.getCircleId());
                    return CirclePoToDto.copyCircleResourcePagerRsp(circleResource, circle);
                })
                .collect(Collectors.toList());
        rspPager.setArray(rspList);

        return rspPager;
    }

    @Override
    public CircleResourceDetailRsp resourceDetail(Long id) {

        CircleResource circleResource = super.findResourceByIdOrFail(id);
        Circle circle = super.findByIdOrFail(circleResource.getCircleId());

        return CirclePoToDto.copyCircleResourceDetailRsp(circleResource, circle);
    }
}
