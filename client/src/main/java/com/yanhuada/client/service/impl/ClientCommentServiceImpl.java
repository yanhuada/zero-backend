package com.yanhuada.client.service.impl;

import com.yanhuada.client.dao.*;
import com.yanhuada.client.jwt.JwtSessionUtil;
import com.yanhuada.client.model.comment.CommentPoToDto;
import com.yanhuada.client.model.comment.req.CommentPagerReq;
import com.yanhuada.client.model.comment.rsp.CommentNumRsp;
import com.yanhuada.client.model.comment.rsp.CommentPagerRsp;
import com.yanhuada.client.model.comment.rsp.CommentSubRsp;
import com.yanhuada.client.service.*;
import com.yanhuada.common.enumeration.CommentType;
import com.yanhuada.common.model.Pager;
import com.yanhuada.common.model.PagerDto;
import com.yanhuada.common.util.aliyun.oss.OssUtil;
import com.yanhuada.model.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author yanhuada
 * CREATE ON 2020/9/3 21:34
 */
@Service
public class ClientCommentServiceImpl implements ClientCommentService {

    @Resource
    private ClientCircleTopicContentCommentMapper clientCircleTopicContentCommentMapper;
    @Resource
    private ClientCircleTopicContentSubCommentMapper clientCircleTopicContentSubCommentMapper;
    @Resource
    private ClientSmallVideoService clientSmallVideoService;
    @Resource
    private ClientSmallVideoCommentMapper clientSmallVideoCommentMapper;
    @Resource
    private ClientSmallVideoSubCommentMapper clientSmallVideoSubCommentMapper;
    @Resource
    private ClientWeeklyService clientWeeklyService;
    @Resource
    private ClientWeeklyCommentMapper clientWeeklyCommentMapper;
    @Resource
    private ClientWeeklySubCommentMapper clientWeeklySubCommentMapper;
    @Resource
    private ClientCommentLikeMapper clientCommentLikeMapper;
    @Resource
    private ClientCircleService clientCircleService;
    @Resource
    private ClientCircleTopicContentMapper clientCircleTopicContentMapper;
    @Resource
    private ClientUserService clientUserService;
    @Resource
    private JwtSessionUtil jwtSessionUtil;
    @Resource
    private HttpServletRequest request;
    @Resource
    private OssUtil ossUtil;

    @Override
    public CommentNumRsp num(CommentType type, Long entityId) {
        switch (type) {
            case TOPIC:
                Long commentNum = clientCircleTopicContentCommentMapper.total(entityId);

                break;
            case VIDEO:
                break;
            case WEEKLY:

                break;
            default:
                System.out.println("类型错误！！！！！");
        }
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void add(CommentType type, boolean ifSub, Long entityId, String content) {
        switch (type) {
            case TOPIC:
                topicCommentAdd(ifSub, entityId, content,false);
                break;
            case VIDEO:
                videoCommentAdd(ifSub, entityId, content,false);
                break;
            case WEEKLY:
                weeklyCommentAdd(ifSub, entityId, content,false);
                break;
            default:
                System.out.println("类型错误！！！！！");
        }

    }

    @Override
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
     public void add(CommentType type, Long entityId, String content) {
        switch (type) {
            case TOPIC:
                topicCommentAdd(true, entityId, content,true);
                break;
            case VIDEO:
                videoCommentAdd(true, entityId, content,true);
                break;
            case WEEKLY:
                weeklyCommentAdd(true, entityId, content,true);
                break;
            default:
                System.out.println("类型错误！！！！！");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void like(CommentType type, boolean ifSub, Long entityId, boolean ifLike) {
        Long userId = jwtSessionUtil.getUserIdFromAuthenticatedSession(request);
        if (!ifLike) {
            CommentLikeExample example = new CommentLikeExample();
            example.createCriteria() .andTypeEqualTo(type.getCode()).andIfSubEqualTo(ifSub).andEntityIdEqualTo(entityId).andUserIdEqualTo(userId);
            clientCommentLikeMapper.deleteByExample(example);
            this.updateCommentLikeNum(type, ifSub, entityId, false);
        } else {
            CommentLike commentLike = clientCommentLikeMapper.selectOne(type.getCode(), ifSub, entityId, userId);
            if (commentLike == null) {
                this.addCommentLike(userId, entityId, type.getCode(), ifSub);
                this.updateCommentLikeNum(type, ifSub, entityId, true);
            }
        }

    }

    @Override
    public Pager<CommentPagerRsp> pagination(CommentType type, CommentPagerReq req) {
        Pager<CommentPagerRsp> rspPager = new Pager<>(req.getPage(), req.getCount());
        switch (type) {
            case TOPIC:
                rspPager.setTotal(Math.toIntExact(clientCircleTopicContentCommentMapper.total(req.getEntityId())));
                rspPager.setArray(this.topicCommentList(req.getEntityId(), req));
                return rspPager;
            case WEEKLY:
                rspPager.setTotal(Math.toIntExact(clientWeeklyCommentMapper.total(req.getEntityId())));
                rspPager.setArray(this.weeklyCommentList(req.getEntityId(), req));
                return rspPager;
            case VIDEO:
                rspPager.setTotal(Math.toIntExact(clientSmallVideoCommentMapper.total(req.getEntityId())));
                rspPager.setArray(this.videoCommentList(req.getEntityId(), req));
                return rspPager;
            default:
                System.out.println("错误评论类型");
                return rspPager;
        }
    }

    private List<CommentPagerRsp> topicCommentList(Long entityId, PagerDto page) {
        List<CircleTopicContentComment> circleTopicContentCommentList = clientCircleTopicContentCommentMapper.list(entityId, page);
        return circleTopicContentCommentList
                .stream()
                .map(circleTopicContentComment -> {
                    boolean ifLike = this.commentIfLike(CommentType.TOPIC.getCode(), false, circleTopicContentComment.getId());
                    Long total = clientCircleTopicContentSubCommentMapper.total(circleTopicContentComment.getId());
                    if (total == 0) {
                        return CommentPoToDto.copyCommentPagerRsp(circleTopicContentComment, ifLike, 0, new ArrayList<>(), ossUtil);
                    }
                    List<CommentSubRsp> subRspList = this.listSubComment(CommentType.TOPIC, circleTopicContentComment.getId());

                    return CommentPoToDto.copyCommentPagerRsp(circleTopicContentComment, ifLike, Math.toIntExact(total), subRspList, ossUtil);
                })
                .collect(Collectors.toList());
    }

    private List<CommentPagerRsp> weeklyCommentList(Long entityId, PagerDto page) {
        List<WeeklyComment> weeklyCommentList = clientWeeklyCommentMapper.list(entityId, page);
        return weeklyCommentList.stream()
                .map(weeklyComment -> {
                    boolean ifLike = this.commentIfLike(CommentType.TOPIC.getCode(), false, weeklyComment.getId());
                    Long total = clientWeeklyCommentMapper.total(weeklyComment.getId());
                    if (total == 0) {
                        return CommentPoToDto.copyCommentPagerRsp(weeklyComment, ifLike, 0, new ArrayList<>(), ossUtil);
                    }
                    List<CommentSubRsp> subRspList = this.listSubComment(CommentType.WEEKLY, weeklyComment.getId());
                    return CommentPoToDto.copyCommentPagerRsp(weeklyComment, ifLike, Math.toIntExact(total), subRspList, ossUtil);
                })
                .collect(Collectors.toList());
    }

    private List<CommentPagerRsp> videoCommentList(Long entityId, PagerDto page) {
        List<SmallVideoComment> smallVideoCommentList = clientSmallVideoCommentMapper.list(entityId, page);
        return smallVideoCommentList.stream()
                .map(smallVideoComment -> {
                    boolean ifLike = this.commentIfLike(CommentType.TOPIC.getCode(), false, smallVideoComment.getId());
                    Long total = clientWeeklyCommentMapper.total(smallVideoComment.getId());
                    if (total == 0) {
                        return CommentPoToDto.copyCommentPagerRsp(smallVideoComment, ifLike, 0, new ArrayList<>(), ossUtil);
                    }
                    List<CommentSubRsp> subRspList = this.listSubComment(CommentType.VIDEO, smallVideoComment.getId());
                    return CommentPoToDto.copyCommentPagerRsp(smallVideoComment, ifLike, Math.toIntExact(total), subRspList, ossUtil);
                })
                .collect(Collectors.toList());
    }

    private List<CommentSubRsp> listSubComment(CommentType type, Long entityId) {
        switch (type) {
            case TOPIC:
                List<CircleTopicContentSubComment> circleTopicContentSubCommentList = clientCircleTopicContentSubCommentMapper.list(entityId, null);
                return circleTopicContentSubCommentList.stream()
                        .map(circleTopicContentSubComment -> {
                            boolean ifLike = this.commentIfLike(CommentType.TOPIC.getCode(), true, circleTopicContentSubComment.getId());
                            return CommentPoToDto.copyCommentSubRsp(circleTopicContentSubComment, ifLike, ossUtil);
                        })
                        .collect(Collectors.toList());
            case WEEKLY:
                List<WeeklySubComment> weeklySubCommentList = clientWeeklySubCommentMapper.list(entityId, null);
                return weeklySubCommentList.stream()
                        .map(weeklySubComment -> {
                            boolean ifLike = this.commentIfLike(CommentType.TOPIC.getCode(), true, weeklySubComment.getId());
                            return CommentPoToDto.copyCommentSubRsp(weeklySubComment, ifLike, ossUtil);
                        })
                        .collect(Collectors.toList());
            case VIDEO:
                List<SmallVideoSubComment> smallVideoSubCommentList = clientSmallVideoSubCommentMapper.list(entityId, null);
                return smallVideoSubCommentList.stream()
                        .map(smallVideoSubComment -> {
                            boolean ifLike = this.commentIfLike(CommentType.TOPIC.getCode(), true, smallVideoSubComment.getId());
                            return CommentPoToDto.copyCommentSubRsp(smallVideoSubComment, ifLike, ossUtil);
                        })
                        .collect(Collectors.toList());
            default:
                return new ArrayList<>();
        }
    }

    private Boolean commentIfLike(Integer type, boolean ifSub, Long entityId) {
        if (jwtSessionUtil.ifAnonymous(request)) {
            return false;
        }
        Long userId = jwtSessionUtil.getUserIdFromAuthenticatedSession(request);
        CommentLike commentLike = clientCommentLikeMapper.selectOne(type, ifSub, entityId, userId);
        return commentLike != null;
    }

    private void topicCommentAdd(boolean ifSub, Long entityId, String content,boolean rootIfSub) {
        Long userId = jwtSessionUtil.getUserIdFromAuthenticatedSession(request);
        User user = clientUserService.findByIdFail(userId);
        if (!ifSub) {
            CircleTopicContent circleTopicContent = clientCircleTopicContentMapper.selectByPrimaryKey(entityId);
            CircleTopicContentComment comment = new CircleTopicContentComment();
            comment.setUserId(user.getId());
            comment.setUserAvatar(user.getAvatar());
            comment.setUserNickname(user.getNickname());
            comment.setIfDelete(false);
            comment.setCircleTopicContentId(circleTopicContent.getId());
            comment.setLikeNum(0);
            comment.setReplyNum(0);
            comment.setContent(content);
            clientCircleTopicContentCommentMapper.insertSelective(comment);

        } else {
            CircleTopicContentComment circleTopicContentComment = clientCircleTopicContentCommentMapper.selectByPrimaryKey(entityId);
            CircleTopicContentSubComment comment = new CircleTopicContentSubComment();
            comment.setUserId(user.getId());
            comment.setUserAvatar(user.getAvatar());
            comment.setCircleTopicContentCommentId(circleTopicContentComment.getId());
            comment.setUserNickname(user.getNickname());
            comment.setIfDelete(false);
            comment.setLikeNum(0);
            comment.setContent(content);
            if (rootIfSub){
                comment.setRootUserId(circleTopicContentComment.getUserId());
                comment.setRootUserNickname(circleTopicContentComment.getUserNickname());
                comment.setRootUserAvatar(circleTopicContentComment.getUserAvatar());
            }
            clientCircleTopicContentSubCommentMapper.insertSelective(comment);

            this.addCommentReplyNum(CommentType.TOPIC,circleTopicContentComment.getId());
        }
    }

    private void weeklyCommentAdd(boolean ifSub, Long entityId, String content,boolean rootIfSub) {
        Long userId = jwtSessionUtil.getUserIdFromAuthenticatedSession(request);
        User user = clientUserService.findByIdFail(userId);
        if (!ifSub) {
            Weekly weekly = clientWeeklyService.findByIdOrFail(entityId);
            WeeklyComment comment = new WeeklyComment();
            comment.setWeeklyId(weekly.getId());
            comment.setUserId(user.getId());
            comment.setUserNickname(user.getNickname());
            comment.setUserAvatar(user.getAvatar());
            comment.setContent(content);
            comment.setIfDelete(false);
            comment.setLikeNum(0);
            comment.setReplyNum(0);
            clientWeeklyCommentMapper.insertSelective(comment);


        } else {
            WeeklyComment weeklyComment = clientWeeklyCommentMapper.selectByPrimaryKey(entityId);
            WeeklySubComment comment = new WeeklySubComment();
            comment.setUserId(user.getId());
            comment.setUserNickname(user.getNickname());
            comment.setUserAvatar(user.getAvatar());
            comment.setWeeklyCommentId(weeklyComment.getId());
            comment.setRootUserId(weeklyComment.getUserId());
            comment.setRootUserNickname(weeklyComment.getUserNickname());
            comment.setRootUserAvatar(weeklyComment.getUserAvatar());
            comment.setContent(content);
            comment.setIfDelete(false);
            comment.setLikeNum(0);
            if (rootIfSub){
                comment.setRootUserId(weeklyComment.getUserId());
                comment.setRootUserNickname(weeklyComment.getUserNickname());
                comment.setRootUserAvatar(weeklyComment.getUserAvatar());
            }
            clientWeeklySubCommentMapper.insertSelective(comment);

            this.addCommentReplyNum(CommentType.WEEKLY,weeklyComment.getId());
        }
    }

    private void videoCommentAdd(boolean ifSub, Long entityId, String content,boolean rootIfSub) {
        Long userId = jwtSessionUtil.getUserIdFromAuthenticatedSession(request);
        User user = clientUserService.findByIdFail(userId);
        if (!ifSub) {
            SmallVideo smallVideo = clientSmallVideoService.findByIdOrFail(entityId);
            SmallVideoComment comment = new SmallVideoComment();
            comment.setSmallVideoId(smallVideo.getId());
            comment.setUserId(user.getId());
            comment.setUserNickname(user.getNickname());
            comment.setUserAvatar(user.getAvatar());
            comment.setContent(content);
            comment.setIfDelete(false);
            comment.setLikeNum(0);
            comment.setReplyNum(0);
            clientSmallVideoCommentMapper.insertSelective(comment);



        } else {
            SmallVideoComment smallVideoComment = clientSmallVideoCommentMapper.selectByPrimaryKey(entityId);
            SmallVideoSubComment comment = new SmallVideoSubComment();
            comment.setUserId(user.getId());
            comment.setUserNickname(user.getNickname());
            comment.setUserAvatar(user.getAvatar());
            comment.setSmallVideoCommentId(smallVideoComment.getId());
            comment.setRootUserId(smallVideoComment.getUserId());
            comment.setRootUserNickname(smallVideoComment.getUserNickname());
            comment.setRootUserAvatar(smallVideoComment.getUserAvatar());
            comment.setContent(content);
            comment.setIfDelete(false);
            comment.setLikeNum(0);
            if (rootIfSub){
                comment.setRootUserId(smallVideoComment.getUserId());
                comment.setRootUserNickname(smallVideoComment.getUserNickname());
                comment.setRootUserAvatar(smallVideoComment.getUserAvatar());
            }

            clientSmallVideoSubCommentMapper.insertSelective(comment);

            this.addCommentReplyNum(CommentType.VIDEO,smallVideoComment.getId());
        }
    }

    private void addCommentLike(Long userId, Long entityId, Integer type, boolean ifSub) {
        CommentLike commentLike = new CommentLike();
        commentLike.setUserId(userId);
        commentLike.setEntityId(entityId);
        commentLike.setType(type);
        commentLike.setIfSub(ifSub);
        clientCommentLikeMapper.insertSelective(commentLike);
    }

    private void addCommentReplyNum(CommentType type,Long entityId) {
        switch (type) {
            case TOPIC:
                CircleTopicContentComment circleTopicContentComment = clientCircleTopicContentCommentMapper.selectByPrimaryKey(entityId);
                circleTopicContentComment.setReplyNum(circleTopicContentComment.getReplyNum() + 1);
                clientCircleTopicContentCommentMapper.updateByPrimaryKeySelective(circleTopicContentComment);
                break;
            case WEEKLY:
                WeeklyComment weeklyComment = clientWeeklyCommentMapper.selectByPrimaryKey(entityId);
                weeklyComment.setReplyNum(weeklyComment.getReplyNum() + 1);
                clientWeeklyCommentMapper.updateByPrimaryKeySelective(weeklyComment);
                break;
            case VIDEO:
                SmallVideoComment smallVideoComment = clientSmallVideoCommentMapper.selectByPrimaryKey(entityId);
                smallVideoComment.setReplyNum(smallVideoComment.getReplyNum() + 1);
                clientSmallVideoCommentMapper.updateByPrimaryKeySelective(smallVideoComment);
                break;
            default:
        }
    }

    private void updateCommentLikeNum(CommentType type, boolean ifSub, Long entityId, boolean ifAdd) {
        switch (type) {
            case TOPIC:
                if (ifSub) {
                    CircleTopicContentSubComment circleTopicContentSubComment = clientCircleTopicContentSubCommentMapper.selectByPrimaryKey(entityId);
                    circleTopicContentSubComment.setLikeNum(ifAdd ? circleTopicContentSubComment.getLikeNum() + 1 : circleTopicContentSubComment.getLikeNum() - 1);
                    clientCircleTopicContentSubCommentMapper.updateByPrimaryKeySelective(circleTopicContentSubComment);
                } else {
                    CircleTopicContentComment circleTopicContentComment = clientCircleTopicContentCommentMapper.selectByPrimaryKey(entityId);
                    circleTopicContentComment.setLikeNum(ifAdd ? circleTopicContentComment.getLikeNum() + 1 : circleTopicContentComment.getLikeNum() - 1);
                    clientCircleTopicContentCommentMapper.updateByPrimaryKeySelective(circleTopicContentComment);
                }
                break;
            case WEEKLY:
                if (ifSub) {
                    WeeklySubComment weeklySubComment = clientWeeklySubCommentMapper.selectByPrimaryKey(entityId);
                    weeklySubComment.setLikeNum(ifAdd ? weeklySubComment.getLikeNum() + 1 : weeklySubComment.getLikeNum() - 1);
                    clientWeeklySubCommentMapper.updateByPrimaryKeySelective(weeklySubComment);
                } else {
                    WeeklyComment weeklyComment = clientWeeklyCommentMapper.selectByPrimaryKey(entityId);
                    weeklyComment.setLikeNum(ifAdd ? weeklyComment.getLikeNum() + 1 : weeklyComment.getLikeNum() - 1);
                    clientWeeklyCommentMapper.updateByPrimaryKeySelective(weeklyComment);
                }
                break;
            case VIDEO:
                if (ifSub) {
                    SmallVideoSubComment smallVideoSubComment = clientSmallVideoSubCommentMapper.selectByPrimaryKey(entityId);
                    smallVideoSubComment.setLikeNum(ifAdd ? smallVideoSubComment.getLikeNum() + 1 : smallVideoSubComment.getLikeNum() - 1);
                    clientSmallVideoSubCommentMapper.updateByPrimaryKeySelective(smallVideoSubComment);
                } else {
                    SmallVideoComment smallVideoComment = clientSmallVideoCommentMapper.selectByPrimaryKey(entityId);
                    smallVideoComment.setLikeNum(ifAdd ? smallVideoComment.getLikeNum() + 1 : smallVideoComment.getLikeNum() - 1);
                    clientSmallVideoCommentMapper.updateByPrimaryKeySelective(smallVideoComment);
                }
                break;
            default:
        }
    }
}
