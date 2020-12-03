package com.yanhuada.client.service;

import com.yanhuada.client.model.comment.req.CommentPagerReq;
import com.yanhuada.client.model.comment.rsp.CommentNumRsp;
import com.yanhuada.client.model.comment.rsp.CommentPagerRsp;
import com.yanhuada.common.enumeration.CommentType;
import com.yanhuada.common.model.Pager;

/**
 * @author yanhuada
 * CREATE ON 2020/9/3 21:33
 */
public interface ClientCommentService {

    CommentNumRsp num(CommentType type, Long entityId);

    void add(CommentType type, boolean ifSub, Long entityId, String content);

    void add(CommentType type, Long entityId, String content);

    void like(CommentType type, boolean ifSub, Long entityId, boolean ifLike);

    Pager<CommentPagerRsp> pagination(CommentType type, CommentPagerReq req);
}
