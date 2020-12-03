package com.yanhuada.dao.mapper;

import com.yanhuada.model.CommentLike;
import com.yanhuada.model.CommentLikeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommentLikeMapper {
    long countByExample(CommentLikeExample example);

    int deleteByExample(CommentLikeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommentLike record);

    int insertSelective(CommentLike record);

    List<CommentLike> selectByExample(CommentLikeExample example);

    CommentLike selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CommentLike record, @Param("example") CommentLikeExample example);

    int updateByExample(@Param("record") CommentLike record, @Param("example") CommentLikeExample example);

    int updateByPrimaryKeySelective(CommentLike record);

    int updateByPrimaryKey(CommentLike record);
}