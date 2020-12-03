package com.yanhuada.service;

import com.yanhuada.model.Circle;
import com.yanhuada.model.CircleResource;
import com.yanhuada.model.CircleTopic;
import com.yanhuada.model.CircleTopicContent;

/**
 * @author yanhuada
 * CREATE ON 2020/8/10 17:38
 */
public interface BaseCircleService {

    /**
     * 根据ID查询圈子
     *
     * @param id ID
     * @return 返回圈子对象
     */
    Circle findById(Long id);

    /**
     * 根据ID查询圈子 如果为空，抛出异常
     *
     * @param id ID
     * @return 返回圈子对象
     */
    Circle findByIdOrFail(Long id);


    /**
     * 新增用户数量 +1
     *
     * @param circle 圈子
     */
    void addUserNum(Circle circle);

    /**
     * 根据专题ID获取专题
     *
     * @param topicId topicId
     * @return 专题
     */
    CircleTopic findTopicById(Long topicId);

    /**
     * 根据专题ID获取专题 为空时抛出异常
     *
     * @param topicId topicId
     * @return 专题
     */
    CircleTopic findTopicByIdOrFail(Long topicId);

    /**
     * 根据内容ID查找专题内容
     *
     * @param topicContentId topicContentId
     * @return CircleTopicContent
     */
    CircleTopicContent findTopicContentById(Long topicContentId);

    /**
     * 根据内容ID查找专题内容 为空时抛出异常
     *
     * @param topicContentId topicContentId
     * @return CircleTopicContent
     */
    CircleTopicContent findTopicContentByIdOrFail(Long topicContentId);

    /**
     * 是否加入了该圈子
     *
     * @param userId 用户id
     * @param id     圈子id
     * @return true 或 false
     */
    Boolean ifJoin(Long userId, Long id);

    /**
     * 查找圈子资源
     *
     * @param resourceId 资源id
     * @return 资源
     */
    CircleResource findResourceById(Long resourceId);

    /**
     * 查找圈子资源 为空时抛出异常
     *
     * @param resourceId 资源id
     * @return 资源
     */
    CircleResource findResourceByIdOrFail(Long resourceId);

}
