package com.yanhuada.dao.mapper;

import com.yanhuada.model.Circle;
import com.yanhuada.model.CircleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CircleMapper {
    long countByExample(CircleExample example);

    int deleteByExample(CircleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Circle record);

    int insertSelective(Circle record);

    List<Circle> selectByExampleWithBLOBs(CircleExample example);

    List<Circle> selectByExample(CircleExample example);

    Circle selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Circle record, @Param("example") CircleExample example);

    int updateByExampleWithBLOBs(@Param("record") Circle record, @Param("example") CircleExample example);

    int updateByExample(@Param("record") Circle record, @Param("example") CircleExample example);

    int updateByPrimaryKeySelective(Circle record);

    int updateByPrimaryKeyWithBLOBs(Circle record);

    int updateByPrimaryKey(Circle record);
}