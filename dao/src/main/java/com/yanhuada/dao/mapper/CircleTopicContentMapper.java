package com.yanhuada.dao.mapper;

import com.yanhuada.model.CircleTopicContent;
import com.yanhuada.model.CircleTopicContentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CircleTopicContentMapper {
    long countByExample(CircleTopicContentExample example);

    int deleteByExample(CircleTopicContentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CircleTopicContent record);

    int insertSelective(CircleTopicContent record);

    List<CircleTopicContent> selectByExampleWithBLOBs(CircleTopicContentExample example);

    List<CircleTopicContent> selectByExample(CircleTopicContentExample example);

    CircleTopicContent selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CircleTopicContent record, @Param("example") CircleTopicContentExample example);

    int updateByExampleWithBLOBs(@Param("record") CircleTopicContent record, @Param("example") CircleTopicContentExample example);

    int updateByExample(@Param("record") CircleTopicContent record, @Param("example") CircleTopicContentExample example);

    int updateByPrimaryKeySelective(CircleTopicContent record);

    int updateByPrimaryKeyWithBLOBs(CircleTopicContent record);

    int updateByPrimaryKey(CircleTopicContent record);
}