package com.yanhuada.dao.mapper;

import com.yanhuada.model.WeeklySubComment;
import com.yanhuada.model.WeeklySubCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WeeklySubCommentMapper {
    long countByExample(WeeklySubCommentExample example);

    int deleteByExample(WeeklySubCommentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WeeklySubComment record);

    int insertSelective(WeeklySubComment record);

    List<WeeklySubComment> selectByExample(WeeklySubCommentExample example);

    WeeklySubComment selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WeeklySubComment record, @Param("example") WeeklySubCommentExample example);

    int updateByExample(@Param("record") WeeklySubComment record, @Param("example") WeeklySubCommentExample example);

    int updateByPrimaryKeySelective(WeeklySubComment record);

    int updateByPrimaryKey(WeeklySubComment record);
}