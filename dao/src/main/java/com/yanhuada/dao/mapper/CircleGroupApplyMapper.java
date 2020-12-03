package com.yanhuada.dao.mapper;

import com.yanhuada.model.CircleGroupApply;
import com.yanhuada.model.CircleGroupApplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CircleGroupApplyMapper {
    long countByExample(CircleGroupApplyExample example);

    int deleteByExample(CircleGroupApplyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CircleGroupApply record);

    int insertSelective(CircleGroupApply record);

    List<CircleGroupApply> selectByExample(CircleGroupApplyExample example);

    CircleGroupApply selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CircleGroupApply record, @Param("example") CircleGroupApplyExample example);

    int updateByExample(@Param("record") CircleGroupApply record, @Param("example") CircleGroupApplyExample example);

    int updateByPrimaryKeySelective(CircleGroupApply record);

    int updateByPrimaryKey(CircleGroupApply record);
}