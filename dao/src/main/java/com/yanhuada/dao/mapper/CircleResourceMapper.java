package com.yanhuada.dao.mapper;

import com.yanhuada.model.CircleResource;
import com.yanhuada.model.CircleResourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CircleResourceMapper {
    long countByExample(CircleResourceExample example);

    int deleteByExample(CircleResourceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CircleResource record);

    int insertSelective(CircleResource record);

    List<CircleResource> selectByExampleWithBLOBs(CircleResourceExample example);

    List<CircleResource> selectByExample(CircleResourceExample example);

    CircleResource selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CircleResource record, @Param("example") CircleResourceExample example);

    int updateByExampleWithBLOBs(@Param("record") CircleResource record, @Param("example") CircleResourceExample example);

    int updateByExample(@Param("record") CircleResource record, @Param("example") CircleResourceExample example);

    int updateByPrimaryKeySelective(CircleResource record);

    int updateByPrimaryKeyWithBLOBs(CircleResource record);

    int updateByPrimaryKey(CircleResource record);
}