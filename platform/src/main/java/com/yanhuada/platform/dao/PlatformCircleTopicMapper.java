package com.yanhuada.platform.dao;

import com.yanhuada.dao.mapper.CircleTopicMapper;
import com.yanhuada.model.CircleTopic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yanhuada
 * CREATE ON 2020/8/14 22:25
 */
public interface PlatformCircleTopicMapper extends CircleTopicMapper {

    /**
     * 根据名称查询专题
     *
     * @param circleId 圈子ID
     * @param name     名称
     * @return CircleTopic
     */
    CircleTopic findByName(@Param("circleId") Long circleId, @Param("name") String name);

    /**
     * 查询圈子专题列表
     *
     * @param circleId      圈子ID
     * @param name          专题名称 模糊查询
     * @param publishStatus 专题状态
     * @return 专题列表
     */
    List<CircleTopic> list(@Param("circleId") Long circleId, @Param("name") String name, @Param("publishStatus") Integer publishStatus);
}
