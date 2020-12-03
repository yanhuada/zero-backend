package com.yanhuada.client.dao;

import com.yanhuada.dao.mapper.CommentLikeMapper;
import com.yanhuada.model.CommentLike;

/**
 * @author yanhuada
 * CREATE ON 2020/9/4 22:22
 */
public interface ClientCommentLikeMapper extends CommentLikeMapper {

    CommentLike selectOne(Integer type, boolean ifSub, Long entityId, Long userId);
}
