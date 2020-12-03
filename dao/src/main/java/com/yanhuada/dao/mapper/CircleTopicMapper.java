package com.yanhuada.dao.mapper;

import com.yanhuada.model.CircleTopic;
import com.yanhuada.model.CircleTopicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CircleTopicMapper {
    long countByExample(CircleTopicExample example);

    int deleteByExample(CircleTopicExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CircleTopic record);

    int insertSelective(CircleTopic record);

    List<CircleTopic> selectByExample(CircleTopicExample example);

    CircleTopic selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CircleTopic record, @Param("example") CircleTopicExample example);

    int updateByExample(@Param("record") CircleTopic record, @Param("example") CircleTopicExample example);

    int updateByPrimaryKeySelective(CircleTopic record);

    int updateByPrimaryKey(CircleTopic record);
}