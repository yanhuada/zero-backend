package com.yanhuada.client.dao;

import com.yanhuada.common.model.PagerDto;
import com.yanhuada.dao.mapper.CircleTopicContentCommentMapper;
import com.yanhuada.model.CircleTopicContentComment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yanhuada
 * CREATE ON 2020/9/3 21:42
 */
public interface ClientCircleTopicContentCommentMapper extends CircleTopicContentCommentMapper {

    Long total(@Param("circleTopicContentId") Long circleTopicContentId);
    List<CircleTopicContentComment> list(@Param("circleTopicContentId") Long circleTopicContentId, @Param("page") PagerDto page);
}
