package com.yanhuada.dao.mapper;

import com.yanhuada.model.CircleTopicContentSubComment;
import com.yanhuada.model.CircleTopicContentSubCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CircleTopicContentSubCommentMapper {
    long countByExample(CircleTopicContentSubCommentExample example);

    int deleteByExample(CircleTopicContentSubCommentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CircleTopicContentSubComment record);

    int insertSelective(CircleTopicContentSubComment record);

    List<CircleTopicContentSubComment> selectByExample(CircleTopicContentSubCommentExample example);

    CircleTopicContentSubComment selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CircleTopicContentSubComment record, @Param("example") CircleTopicContentSubCommentExample example);

    int updateByExample(@Param("record") CircleTopicContentSubComment record, @Param("example") CircleTopicContentSubCommentExample example);

    int updateByPrimaryKeySelective(CircleTopicContentSubComment record);

    int updateByPrimaryKey(CircleTopicContentSubComment record);
}