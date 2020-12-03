package com.yanhuada.platform.dao;

import com.yanhuada.common.model.PagerDto;
import com.yanhuada.dao.mapper.CircleTopicContentMapper;
import com.yanhuada.model.CircleTopicContent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yanhuada
 * CREATE ON 2020/8/15 11:38
 */
public interface PlatformCircleTopicContentMapper extends CircleTopicContentMapper {

    /**
     * 查询内容列表
     *
     * @param circleId      圈子ID
     * @param circleTopicId 圈子主题ID
     * @param author        作者
     * @param title         标题
     * @param publishStatus 状态
     * @param page          分页参数
     * @return 内容列表
     */
    List<CircleTopicContent> list(@Param("circleId") Long circleId, @Param("circleTopicId") Long circleTopicId,
                                  @Param("author") String author, @Param("title") String title,
                                  @Param("publishStatus") Integer publishStatus, @Param("page") PagerDto page);

    /**
     * 内容数量
     *
     * @param circleId      圈子ID
     * @param circleTopicId 圈子主题ID
     * @param author        作者
     * @param title         标题
     * @param publishStatus 状态
     * @return 数量
     */
    Long total(@Param("circleId") Long circleId, @Param("circleTopicId") Long circleTopicId,
               @Param("author") String author, @Param("title") String title, @Param("publishStatus") Integer publishStatus);
}
