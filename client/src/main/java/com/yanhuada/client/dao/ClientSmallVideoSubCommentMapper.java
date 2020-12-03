package com.yanhuada.client.dao;

import com.yanhuada.common.model.PagerDto;
import com.yanhuada.dao.mapper.SmallVideoSubCommentMapper;
import com.yanhuada.model.SmallVideoSubComment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yanhuada
 * CREATE ON 2020/9/3 22:05
 */
public interface ClientSmallVideoSubCommentMapper extends SmallVideoSubCommentMapper {

    Long total(@Param("small_video_comment_id") Long smallVideoCommentId);

    List<SmallVideoSubComment> list(@Param("small_video_comment_id") Long smallVideoCommentId, @Param("page") PagerDto page);
}
