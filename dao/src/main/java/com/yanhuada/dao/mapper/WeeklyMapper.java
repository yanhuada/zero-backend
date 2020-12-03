package com.yanhuada.dao.mapper;

import com.yanhuada.model.Weekly;
import com.yanhuada.model.WeeklyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WeeklyMapper {
    long countByExample(WeeklyExample example);

    int deleteByExample(WeeklyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Weekly record);

    int insertSelective(Weekly record);

    List<Weekly> selectByExampleWithBLOBs(WeeklyExample example);

    List<Weekly> selectByExample(WeeklyExample example);

    Weekly selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Weekly record, @Param("example") WeeklyExample example);

    int updateByExampleWithBLOBs(@Param("record") Weekly record, @Param("example") WeeklyExample example);

    int updateByExample(@Param("record") Weekly record, @Param("example") WeeklyExample example);

    int updateByPrimaryKeySelective(Weekly record);

    int updateByPrimaryKeyWithBLOBs(Weekly record);

    int updateByPrimaryKey(Weekly record);
}