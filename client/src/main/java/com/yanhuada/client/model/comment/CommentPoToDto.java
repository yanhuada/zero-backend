package com.yanhuada.client.model.comment;

import com.yanhuada.client.model.comment.rsp.CommentNumRsp;
import com.yanhuada.client.model.comment.rsp.CommentPagerRsp;
import com.yanhuada.client.model.comment.rsp.CommentSubRsp;
import com.yanhuada.common.util.aliyun.oss.OssUtil;
import com.yanhuada.model.*;

import java.util.List;

/**
 * @author yanhuada
 * CREATE ON 2020/8/28 18:07
 */
public class CommentPoToDto {

    public static CommentSubRsp copyCommentSubRsp(CircleTopicContentSubComment circleTopicContentSubComment, Boolean ifLike, OssUtil ossUtil) {
        CommentSubRsp rsp = new CommentSubRsp();
        rsp.setId(circleTopicContentSubComment.getId());
        rsp.setUserId(circleTopicContentSubComment.getUserId());
        rsp.setUserNickname(circleTopicContentSubComment.getUserNickname());
        rsp.setUserAvatar(ossUtil.getFileUrl(circleTopicContentSubComment.getUserAvatar()));
        rsp.setRootUserId(circleTopicContentSubComment.getRootUserId());
        rsp.setRootUserNickname(circleTopicContentSubComment.getRootUserNickname());
        rsp.setRootUserAvatar(circleTopicContentSubComment.getRootUserAvatar());
        rsp.setContent(circleTopicContentSubComment.getContent());
        rsp.setIfDelete(circleTopicContentSubComment.getIfDelete());
        rsp.setLikeNum(circleTopicContentSubComment.getLikeNum());
        rsp.setIfLike(ifLike);
        rsp.setCreatedAt(circleTopicContentSubComment.getCreatedAt());
        return rsp;
    }

    public static CommentSubRsp copyCommentSubRsp(WeeklySubComment weeklySubComment, Boolean ifLike, OssUtil ossUtil) {
        CommentSubRsp rsp = new CommentSubRsp();
        rsp.setId(weeklySubComment.getId());
        rsp.setUserId(weeklySubComment.getUserId());
        rsp.setUserNickname(weeklySubComment.getUserNickname());
        rsp.setUserAvatar(ossUtil.getFileUrl(weeklySubComment.getUserAvatar()));
        rsp.setRootUserId(weeklySubComment.getRootUserId());
        rsp.setRootUserNickname(weeklySubComment.getRootUserNickname());
        rsp.setRootUserAvatar(weeklySubComment.getRootUserAvatar());
        rsp.setContent(weeklySubComment.getContent());
        rsp.setIfDelete(weeklySubComment.getIfDelete());
        rsp.setLikeNum(weeklySubComment.getLikeNum());
        rsp.setIfLike(ifLike);
        rsp.setCreatedAt(weeklySubComment.getCreatedAt());
        return rsp;
    }

    public static CommentSubRsp copyCommentSubRsp(SmallVideoSubComment smallVideoSubComment, Boolean ifLike, OssUtil ossUtil) {
        CommentSubRsp rsp = new CommentSubRsp();
        rsp.setId(smallVideoSubComment.getId());
        rsp.setUserId(smallVideoSubComment.getUserId());
        rsp.setUserNickname(smallVideoSubComment.getUserNickname());
        rsp.setUserAvatar(ossUtil.getFileUrl(smallVideoSubComment.getUserAvatar()));
        rsp.setRootUserId(smallVideoSubComment.getRootUserId());
        rsp.setRootUserNickname(smallVideoSubComment.getRootUserNickname());
        rsp.setRootUserAvatar(smallVideoSubComment.getRootUserAvatar());
        rsp.setContent(smallVideoSubComment.getContent());
        rsp.setIfDelete(smallVideoSubComment.getIfDelete());
        rsp.setLikeNum(smallVideoSubComment.getLikeNum());
        rsp.setIfLike(ifLike);
        rsp.setCreatedAt(smallVideoSubComment.getCreatedAt());
        return rsp;
    }

    public static CommentPagerRsp copyCommentPagerRsp(CircleTopicContentComment circleTopicContentComment, Boolean ifLike, Integer subReplyNum, List<CommentSubRsp> subRspList, OssUtil ossUtil) {
        CommentPagerRsp rsp = new CommentPagerRsp();
        rsp.setId(circleTopicContentComment.getId());
        rsp.setUserId(circleTopicContentComment.getUserId());
        rsp.setUserNickname(circleTopicContentComment.getUserNickname());
        rsp.setUserAvatar(ossUtil.getFileUrl(circleTopicContentComment.getUserAvatar()));
        rsp.setEntityId(circleTopicContentComment.getCircleTopicContentId());
        rsp.setContent(circleTopicContentComment.getContent());
        rsp.setIfDelete(circleTopicContentComment.getIfDelete());
        rsp.setLikeNum(circleTopicContentComment.getLikeNum());
        rsp.setReplyNum(circleTopicContentComment.getReplyNum());
        rsp.setSubReplyNum(subReplyNum);
        rsp.setSubRspList(subRspList);
        rsp.setIfLike(ifLike);
        rsp.setCreatedAt(circleTopicContentComment.getCreatedAt());
        return rsp;
    }

    public static CommentPagerRsp copyCommentPagerRsp(WeeklyComment weeklyComment, Boolean ifLike, Integer subReplyNum, List<CommentSubRsp> subRspList, OssUtil ossUtil) {
        CommentPagerRsp rsp = new CommentPagerRsp();
        rsp.setId(weeklyComment.getId());
        rsp.setUserId(weeklyComment.getUserId());
        rsp.setUserNickname(weeklyComment.getUserNickname());
        rsp.setUserAvatar(ossUtil.getFileUrl(weeklyComment.getUserAvatar()));
        rsp.setEntityId(weeklyComment.getWeeklyId());
        rsp.setContent(weeklyComment.getContent());
        rsp.setIfDelete(weeklyComment.getIfDelete());
        rsp.setLikeNum(weeklyComment.getLikeNum());
        rsp.setReplyNum(weeklyComment.getReplyNum());
        rsp.setSubReplyNum(subReplyNum);
        rsp.setSubRspList(subRspList);
        rsp.setIfLike(ifLike);
        rsp.setCreatedAt(weeklyComment.getCreatedAt());
        return rsp;
    }

    public static CommentPagerRsp copyCommentPagerRsp(SmallVideoComment smallVideoComment, Boolean ifLike, Integer subReplyNum, List<CommentSubRsp> subRspList, OssUtil ossUtil) {
        CommentPagerRsp rsp = new CommentPagerRsp();
        rsp.setId(smallVideoComment.getId());
        rsp.setUserId(smallVideoComment.getUserId());
        rsp.setUserNickname(smallVideoComment.getUserNickname());
        rsp.setUserAvatar(ossUtil.getFileUrl(smallVideoComment.getUserAvatar()));
        rsp.setEntityId(smallVideoComment.getSmallVideoId());
        rsp.setContent(smallVideoComment.getContent());
        rsp.setIfDelete(smallVideoComment.getIfDelete());
        rsp.setLikeNum(smallVideoComment.getLikeNum());
        rsp.setReplyNum(smallVideoComment.getReplyNum());
        rsp.setSubReplyNum(subReplyNum);
        rsp.setSubRspList(subRspList);
        rsp.setIfLike(ifLike);
        rsp.setCreatedAt(smallVideoComment.getCreatedAt());
        return rsp;
    }

    public static CommentNumRsp copyCommentNumRsp(Integer commentNum,Integer likeNum){
        CommentNumRsp rsp = new CommentNumRsp();
        rsp.setCommentNum(commentNum);
        rsp.setLikeNum(likeNum);
        return rsp;
    }
}
