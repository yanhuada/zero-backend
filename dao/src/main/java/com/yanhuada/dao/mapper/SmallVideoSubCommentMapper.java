package com.yanhuada.dao.mapper;

import com.yanhuada.model.SmallVideoSubComment;
import com.yanhuada.model.SmallVideoSubCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmallVideoSubCommentMapper {
    long countByExample(SmallVideoSubCommentExample example);

    int deleteByExample(SmallVideoSubCommentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SmallVideoSubComment record);

    int insertSelective(SmallVideoSubComment record);

    List<SmallVideoSubComment> selectByExample(SmallVideoSubCommentExample example);

    SmallVideoSubComment selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SmallVideoSubComment record, @Param("example") SmallVideoSubCommentExample example);

    int updateByExample(@Param("record") SmallVideoSubComment record, @Param("example") SmallVideoSubCommentExample example);

    int updateByPrimaryKeySelective(SmallVideoSubComment record);

    int updateByPrimaryKey(SmallVideoSubComment record);
}