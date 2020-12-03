package com.yanhuada.client.dao;

import com.yanhuada.common.model.PagerDto;
import com.yanhuada.dao.mapper.SmallVideoCommentMapper;
import com.yanhuada.model.SmallVideoComment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yanhuada
 * CREATE ON 2020/9/3 22:05
 */
public interface ClientSmallVideoCommentMapper extends SmallVideoCommentMapper {

    Long total(@Param("small_video_id") Long smallVideoId);

    List<SmallVideoComment> list(@Param("small_video_id") Long smallVideoId, @Param("page") PagerDto page);
}
