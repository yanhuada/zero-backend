package com.yanhuada.dao.mapper;

import com.yanhuada.model.CircleTopicContentComment;
import com.yanhuada.model.CircleTopicContentCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CircleTopicContentCommentMapper {
    long countByExample(CircleTopicContentCommentExample example);

    int deleteByExample(CircleTopicContentCommentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CircleTopicContentComment record);

    int insertSelective(CircleTopicContentComment record);

    List<CircleTopicContentComment> selectByExample(CircleTopicContentCommentExample example);

    CircleTopicContentComment selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CircleTopicContentComment record, @Param("example") CircleTopicContentCommentExample example);

    int updateByExample(@Param("record") CircleTopicContentComment record, @Param("example") CircleTopicContentCommentExample example);

    int updateByPrimaryKeySelective(CircleTopicContentComment record);

    int updateByPrimaryKey(CircleTopicContentComment record);
}