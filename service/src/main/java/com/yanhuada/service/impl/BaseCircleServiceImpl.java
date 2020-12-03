package com.yanhuada.service.impl;

import com.yanhuada.dao.mapper.*;
import com.yanhuada.exception.CommonException;
import com.yanhuada.exception.ErrorCode;
import com.yanhuada.model.*;
import com.yanhuada.service.BaseCircleService;
import org.apache.commons.collections4.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @author yanhuada
 * CREATE ON 2020/8/10 17:38
 */
public class BaseCircleServiceImpl implements BaseCircleService {

    @Resource
    private CircleMapper circleMapper;
    @Resource
    private CircleTopicMapper circleTopicMapper;
    @Resource
    private CircleTopicContentMapper circleTopicContentMapper;
    @Resource
    private CircleUserMapper circleUserMapper;
    @Resource
    private CircleResourceMapper circleResourceMapper;

    @Override
    public Circle findById(Long id) {
        return circleMapper.selectByPrimaryKey(id);
    }

    @Override
    public Circle findByIdOrFail(Long id) {
        return Optional.ofNullable(findById(id)).orElseThrow(() -> new CommonException(ErrorCode.CIRCLE_NOT_FOUND));
    }

    @Override
    public void addUserNum(Circle circle) {
        circle.setUserNum(circle.getUserNum() + 1);
        circleMapper.updateByPrimaryKeySelective(circle);
    }

    @Override
    public CircleTopic findTopicById(Long topicId) {
        return circleTopicMapper.selectByPrimaryKey(topicId);
    }

    @Override
    public CircleTopic findTopicByIdOrFail(Long topicId) {
        return Optional.ofNullable(findTopicById(topicId)).orElseThrow(() -> new CommonException(ErrorCode.CIRCLE_TOPIC_NOT_FOUND));
    }

    @Override
    public CircleTopicContent findTopicContentById(Long topicContentId) {
        return circleTopicContentMapper.selectByPrimaryKey(topicContentId);
    }

    @Override
    public CircleTopicContent findTopicContentByIdOrFail(Long topicContentId) {
        return Optional.ofNullable(findTopicContentById(topicContentId))
                .orElseThrow(() -> new CommonException(ErrorCode.CIRCLE_TOPIC_CONTENT_NOT_FOUND));
    }

    @Override
    public Boolean ifJoin(Long userId, Long id) {
        CircleUserExample example = new CircleUserExample();
        example.createCriteria().andUserIdEqualTo(userId).andCircleIdEqualTo(id);
        List<CircleUser> circleUserList = circleUserMapper.selectByExample(example);
        return CollectionUtils.isNotEmpty(circleUserList);
    }

    @Override
    public CircleResource findResourceById(Long resourceId) {
        return circleResourceMapper.selectByPrimaryKey(resourceId);
    }

    @Override
    public CircleResource findResourceByIdOrFail(Long resourceId) {
        return Optional.ofNullable(findResourceById(resourceId)).orElseThrow(() -> new CommonException(ErrorCode.CIRCLE_RESOURCE_NOT_FOUND));
    }
}
