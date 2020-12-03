package com.yanhuada.dao.mapper;

import com.yanhuada.model.CircleTopicContentLike;
import com.yanhuada.model.CircleTopicContentLikeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CircleTopicContentLikeMapper {
    long countByExample(CircleTopicContentLikeExample example);

    int deleteByExample(CircleTopicContentLikeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CircleTopicContentLike record);

    int insertSelective(CircleTopicContentLike record);

    List<CircleTopicContentLike> selectByExample(CircleTopicContentLikeExample example);

    CircleTopicContentLike selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CircleTopicContentLike record, @Param("example") CircleTopicContentLikeExample example);

    int updateByExample(@Param("record") CircleTopicContentLike record, @Param("example") CircleTopicContentLikeExample example);

    int updateByPrimaryKeySelective(CircleTopicContentLike record);

    int updateByPrimaryKey(CircleTopicContentLike record);
}