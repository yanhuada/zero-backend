package com.yanhuada.client.controller;


import com.yanhuada.client.model.comment.req.CommentAddReq;
import com.yanhuada.client.model.comment.req.CommentLikeReq;
import com.yanhuada.client.model.comment.req.CommentPagerReq;
import com.yanhuada.client.model.comment.rsp.CommentPagerRsp;
import com.yanhuada.client.service.ClientCommentService;
import com.yanhuada.common.enumeration.CommentType;
import com.yanhuada.common.model.PagerResponseDto;
import com.yanhuada.common.model.ResponseDto;
import io.swagger.annotations.Api;

import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * @author yanhuada
 * CREATE ON 2020/8/10 16:58
 */
@Api(tags = "评论接口")
@Validated
@RestController
@RequestMapping("/api/comment")
public class CommentController {

    @Resource
    private ClientCommentService clientCommentService;

    @ApiOperation(value = "评论和点赞数量",nickname = "topic/content/comment/num")
    @GetMapping(value = "topic/content/comment/num")
    public ResponseDto topicContentCommentNum() {

        return new ResponseDto();
    }

    @ApiOperation(value = "专题新增评论", nickname = "topic/content/comment/add")
    @PostMapping(value = "topic/content/comment/add")
    public ResponseDto topicContentCommentAdd(@Validated @RequestBody CommentAddReq req) {
        clientCommentService.add(CommentType.TOPIC, false, req.getEntityId(), req.getContent());
        return new ResponseDto();
    }

    @ApiOperation(value = "周刊新增评论", nickname = "weekly/comment/add")
    @PostMapping(value = "weekly/comment/add")
    public ResponseDto weeklyCommentAdd(@Validated @RequestBody CommentAddReq req) {
        clientCommentService.add(CommentType.WEEKLY, false, req.getEntityId(), req.getContent());
        return new ResponseDto();
    }

    @ApiOperation(value = "视频新增评论", nickname = "video/comment/add")
    @PostMapping(value = "video/comment/add")
    public ResponseDto videoCommentAdd(@Validated @RequestBody CommentAddReq req) {
        clientCommentService.add(CommentType.VIDEO, false, req.getEntityId(), req.getContent());
        return new ResponseDto();
    }

    @ApiOperation(value = "专题新增子评论", nickname = "topic/content/sub/comment/add")
    @PostMapping(value = "topic/content/sub/comment/add")
    public ResponseDto topicContentSubCommentAdd(@Validated @RequestBody CommentAddReq req) {
        clientCommentService.add(CommentType.TOPIC, true, req.getEntityId(), req.getContent());
        return new ResponseDto();
    }


    @ApiOperation(value = "专题回复子评论", nickname = "topic/content/sub/reply/comment/add")
    @PostMapping(value = "topic/content/sub/reply/comment/add")
    public ResponseDto topicContentSubReplyCommentAdd(@Validated @RequestBody CommentAddReq req) {
        clientCommentService.add(CommentType.TOPIC, req.getEntityId(), req.getContent());
        return new ResponseDto();
    }

    @ApiOperation(value = "周刊新增子评论", nickname = "weekly/sub/comment/add")
    @PostMapping(value = "weekly/sub/comment/add")
    public ResponseDto weeklySubCommentAdd(@Validated @RequestBody CommentAddReq req) {
        clientCommentService.add(CommentType.WEEKLY, true, req.getEntityId(), req.getContent());
        return new ResponseDto();
    }

    @ApiOperation(value = "周刊回复子评论", nickname = "weekly/sub/reply/comment/add")
    @PostMapping(value = "weekly/sub/reply/comment/add")
    public ResponseDto weeklySubReplyCommentAdd(@Validated @RequestBody CommentAddReq req) {
        clientCommentService.add(CommentType.WEEKLY, req.getEntityId(), req.getContent());
        return new ResponseDto();
    }

    @ApiOperation(value = "视频新增子评论", nickname = "video/sub/comment/add")
    @PostMapping(value = "video/sub/comment/add")
    public ResponseDto videoSubCommentAdd(@Validated @RequestBody CommentAddReq req) {
        clientCommentService.add(CommentType.VIDEO, true, req.getEntityId(), req.getContent());
        return new ResponseDto();
    }

    @ApiOperation(value = "视频回复子评论", nickname = "video/sub/reply/comment/add")
    @PostMapping(value = "video/sub/reply/comment/add")
    public ResponseDto videoSubReplyCommentAdd(@Validated @RequestBody CommentAddReq req) {
        clientCommentService.add(CommentType.VIDEO, req.getEntityId(), req.getContent());
        return new ResponseDto();
    }

    @ApiOperation(value = "专题评论点赞和取消点赞", nickname = "topic/content/comment/like")
    @PostMapping(value = "topic/content/comment/like")
    public ResponseDto topicContentCommentLike(@Validated @RequestBody CommentLikeReq req) {
        System.out.println("实体id："+ req.getEntityId());
        clientCommentService.like(CommentType.TOPIC, false, req.getEntityId(), req.getIfLike());
        return new ResponseDto();
    }

    @ApiOperation(value = "周刊评论点赞和取消点赞", nickname = "weekly/comment/like")
    @PostMapping(value = "weekly/comment/like")
    public ResponseDto weeklyCommentLike(@Validated @RequestBody CommentLikeReq req) {
        clientCommentService.like(CommentType.WEEKLY, false, req.getEntityId(), req.getIfLike());
        return new ResponseDto();
    }

    @ApiOperation(value = "视频评论点赞和取消点赞", nickname = "video/comment/like")
    @PostMapping(value = "video/comment/like")
    public ResponseDto videoCommentLike(@Validated @RequestBody CommentLikeReq req) {
        clientCommentService.like(CommentType.VIDEO, false, req.getEntityId(), req.getIfLike());
        return new ResponseDto();
    }

    @ApiOperation(value = "专题新增子评论", nickname = "topic/content/sub/comment/like")
    @PostMapping(value = "topic/content/sub/comment/like")
    public ResponseDto topicContentSubCommentLike(@Validated @RequestBody CommentLikeReq req) {
        clientCommentService.like(CommentType.TOPIC, true, req.getEntityId(), req.getIfLike());
        return new ResponseDto();
    }

    @ApiOperation(value = "周刊新增子评论", nickname = "weekly/sub/comment/like")
    @PostMapping(value = "weekly/sub/comment/like")
    public ResponseDto weeklySubCommentLike(@Validated @RequestBody CommentLikeReq req) {
        clientCommentService.like(CommentType.WEEKLY, true, req.getEntityId(), req.getIfLike());
        return new ResponseDto();
    }

    @ApiOperation(value = "视频新增子评论", nickname = "video/sub/comment/like")
    @PostMapping(value = "video/sub/comment/like")
    public ResponseDto videoSubCommentLike(@Validated @RequestBody CommentLikeReq req) {
        clientCommentService.like(CommentType.VIDEO, true, req.getEntityId(), req.getIfLike());
        return new ResponseDto();
    }

    @ApiOperation(value = "专题内容评论分页", nickname = "topic/content/comment/pagination")
    @GetMapping(value = "topic/content/comment/pagination")
    public PagerResponseDto<CommentPagerRsp> topicContentCommentPagination(@Validated CommentPagerReq req) {
        return new PagerResponseDto<>(clientCommentService.pagination(CommentType.TOPIC, req));
    }

    @ApiOperation(value = "周刊评论分页", nickname = "weekly/comment/pagination")
    @GetMapping(value = "weekly/comment/pagination")
    public PagerResponseDto<CommentPagerRsp> weeklyCommentPagination(@Validated CommentPagerReq req) {
        return new PagerResponseDto<>(clientCommentService.pagination(CommentType.WEEKLY, req));
    }

    @ApiOperation(value = "视频评论分页", nickname = "video/comment/pagination")
    @GetMapping(value = "video/comment/pagination")
    public PagerResponseDto<CommentPagerRsp> videoCommentPagination(@Validated CommentPagerReq req) {
        return new PagerResponseDto<>(clientCommentService.pagination(CommentType.VIDEO, req));
    }
}
