package com.yanhuada.dao.mapper;

import com.yanhuada.model.WeeklyComment;
import com.yanhuada.model.WeeklyCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WeeklyCommentMapper {
    long countByExample(WeeklyCommentExample example);

    int deleteByExample(WeeklyCommentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WeeklyComment record);

    int insertSelective(WeeklyComment record);

    List<WeeklyComment> selectByExample(WeeklyCommentExample example);

    WeeklyComment selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WeeklyComment record, @Param("example") WeeklyCommentExample example);

    int updateByExample(@Param("record") WeeklyComment record, @Param("example") WeeklyCommentExample example);

    int updateByPrimaryKeySelective(WeeklyComment record);

    int updateByPrimaryKey(WeeklyComment record);
}