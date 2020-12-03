package com.yanhuada.client.dao;

import com.yanhuada.common.model.PagerDto;
import com.yanhuada.dao.mapper.CircleTopicContentSubCommentMapper;
import com.yanhuada.model.CircleTopicContentSubComment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yanhuada
 * CREATE ON 2020/9/3 21:43
 */
public interface ClientCircleTopicContentSubCommentMapper extends CircleTopicContentSubCommentMapper {

    Long total(@Param("circleTopicContentCommentId") Long circleTopicContentCommentId);

    List<CircleTopicContentSubComment> list(@Param("circleTopicContentCommentId") Long circleTopicContentCommentId, @Param("page") PagerDto page);
}
