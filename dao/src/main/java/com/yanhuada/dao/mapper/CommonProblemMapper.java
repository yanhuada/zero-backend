package com.yanhuada.dao.mapper;

import com.yanhuada.model.CommonProblem;
import com.yanhuada.model.CommonProblemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommonProblemMapper {
    long countByExample(CommonProblemExample example);

    int deleteByExample(CommonProblemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommonProblem record);

    int insertSelective(CommonProblem record);

    List<CommonProblem> selectByExampleWithBLOBs(CommonProblemExample example);

    List<CommonProblem> selectByExample(CommonProblemExample example);

    CommonProblem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CommonProblem record, @Param("example") CommonProblemExample example);

    int updateByExampleWithBLOBs(@Param("record") CommonProblem record, @Param("example") CommonProblemExample example);

    int updateByExample(@Param("record") CommonProblem record, @Param("example") CommonProblemExample example);

    int updateByPrimaryKeySelective(CommonProblem record);

    int updateByPrimaryKeyWithBLOBs(CommonProblem record);

    int updateByPrimaryKey(CommonProblem record);
}