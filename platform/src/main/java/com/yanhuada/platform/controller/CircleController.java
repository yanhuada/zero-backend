package com.yanhuada.platform.controller;

import com.yanhuada.common.model.*;
import com.yanhuada.platform.model.circle.req.*;
import com.yanhuada.platform.model.circle.rsp.*;
import com.yanhuada.platform.service.PlatformCircleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author yanhuada
 * CREATE ON 2020/8/12 18:03
 */
@Api(tags = "圈子相关接口")
@Validated
@RestController
@RequestMapping("/pf-api/circle")
public class CircleController {

    @Resource
    private PlatformCircleService platformCircleService;

    @ApiOperation(value = "新增圈子", nickname = "add")
    @PostMapping(value = "add")
    public ResponseDto add(@Validated @RequestBody CircleAddReq req) {
        platformCircleService.add(req.getName(), req.getIcon(), req.getCover(), req.getIntroduce());
        return new ResponseDto();
    }

    @ApiOperation(value = "圈子分页", nickname = "pagination")
    @GetMapping(value = "pagination")
    public PagerResponseDto<CirclePagerRsp> pagination(@Validated CirclePagerReq req) {
        return new PagerResponseDto<>(platformCircleService.pagination(req));
    }

    @ApiOperation(value = "圈子列表", nickname = "list")
    @GetMapping(value = "list")
    public ListResponseDto<CirclePagerRsp> list(@RequestParam(defaultValue = "") String name) {
        return new ListResponseDto<>(platformCircleService.list(name));
    }

    @ApiOperation(value = "圈子详情", nickname = "detail")
    @GetMapping(value = "detail")
    public ResponseDto<CircleDetailRsp> detail(@Validated IdReq req) {
        return new ResponseDto<>(platformCircleService.detail(req.getId()));
    }

    @ApiOperation(value = "圈子是否上架", nickname = "enable")
    @PostMapping(value = "enable")
    public ResponseDto enable(@Validated @RequestBody EnableReq req) {
        platformCircleService.enable(req.getId(), req.getIfEnable());
        return new ResponseDto();
    }

    /**
     * -------------------------------------------------------------------------------------
     * 圈子用户模块
     */

    @ApiOperation(value = "圈子用户分页", nickname = "user/pagination")
    @GetMapping(value = "user/pagination")
    public PagerResponseDto userPagination() {
        return new PagerResponseDto();
    }

    @ApiOperation(value = "加入圈子", nickname = "join")
    @PostMapping(value = "join")
    public ResponseDto join() {

        return new ResponseDto();
    }

    @ApiOperation(value = "退出圈子", nickname = "quit")
    @PostMapping(value = "quit")
    public ResponseDto quit() {

        return new ResponseDto();
    }

    @ApiOperation(value = "加入相关群", nickname = "group/add")
    @PostMapping(value = "group/add")
    public ResponseDto groupAdd() {

        return new ResponseDto();
    }

    @ApiOperation(value = "退出相关群", nickname = "group/delete")
    @PostMapping(value = "group/delete")
    public ResponseDto groupDelete() {

        return new ResponseDto();
    }


    /**
     * --------------------------------------------------------------------------------------------------------
     * 专题模块
     */

    @ApiOperation(value = "新增专题", nickname = "topic/add")
    @PostMapping(value = "topic/add")
    public ResponseDto topicAdd(@Validated @RequestBody CircleTopicAddReq req) {
        platformCircleService.topicAdd(req.getCircleId(), req.getName(), req.getSort());
        return new ResponseDto();
    }

    @ApiOperation(value = "编辑专题", nickname = "topic/update")
    @PostMapping(value = "topic/update")
    public ResponseDto topicUpdate(@Validated @RequestBody CircleTopicUpdateReq req) {
        platformCircleService.topicUpdate(req.getId(), req.getName(), req.getSort());
        return new ResponseDto();
    }

    @ApiOperation(value = "专题是否上架", nickname = "topic/enable")
    @PostMapping(value = "topic/enable")
    public ResponseDto topicEnable(@Validated @RequestBody EnableReq req) {
        platformCircleService.topicEnable(req.getId(), req.getIfEnable());
        return new ResponseDto();
    }

    @ApiOperation(value = "专题列表", nickname = "topic/list")
    @GetMapping(value = "topic/list")
    public ListResponseDto<CircleTopicListRsp> topicList(@Validated CircleTopicListReq req) {
        return new ListResponseDto<>(platformCircleService.topicList(req.getCircleId(), req.getName(), req.getPublishStatus()));
    }

    @ApiOperation(value = "删除专题", nickname = "topic/delete")
    @PostMapping(value = "topic/delete")
    public ResponseDto topicDelete() {

        return new ResponseDto();
    }

    @ApiOperation(value = "新增专题内容", nickname = "topic/content/add")
    @PostMapping(value = "topic/content/add")
    public ResponseDto topicContentAdd(@Validated @RequestBody CircleTopicContentAddReq req) {
        platformCircleService.topicContentAdd(req.getCircleTopicId(), req.getAuthor(), req.getTitle(), req.getContent());
        return new ResponseDto();
    }

    @ApiOperation(value = "编辑专题内容", nickname = "topic/content/update")
    @PostMapping(value = "topic/content/update")
    public ResponseDto topicContentUpdate(@Validated @RequestBody CircleTopicContentUpdateReq req) {
        platformCircleService.topicContentUpdate(req.getId(), req.getAuthor(), req.getTitle(), req.getContent());
        return new ResponseDto();
    }

    @ApiOperation(value = "专题内容是否上架", nickname = "topic/content/enable")
    @PostMapping(value = "topic/content/enable")
    public ResponseDto topicContentEnable(@Validated @RequestBody EnableReq req) {
        platformCircleService.topicContentEnable(req.getId(), req.getIfEnable());
        return new ResponseDto();
    }

    @ApiOperation(value = "删除专题内容", nickname = "topic/content/delete")
    @PostMapping(value = "topic/content/delete")
    public ResponseDto topicContentDelete() {

        return new ResponseDto();
    }

    @ApiOperation(value = "专题内容分页", nickname = "topic/content/pagination")
    @GetMapping(value = "topic/content/pagination")
    public PagerResponseDto<CircleTopicContentPagerRsp> topicContentPagination(@Validated CircleTopicContentPagerReq req) {
        return new PagerResponseDto<>(platformCircleService.topicContentPagination(req));
    }

    @ApiOperation(value = "专题内容详情", nickname = "topic/content/detail")
    @GetMapping(value = "topic/content/detail")
    public ResponseDto<CircleTopicContentDetailRsp> copyCircleTopicContentDetailRsp(@Validated IdReq req) {
        return new ResponseDto<>(platformCircleService.topicContentDetail(req.getId()));
    }

    @ApiOperation(value = "专题内容评论分页", nickname = "topic/content/comment/pagination")
    @GetMapping(value = "topic/content/comment/pagination")
    public PagerResponseDto topicContentCommentPagination() {

        return new PagerResponseDto();
    }

    @ApiOperation(value = "专题内容子评论分页", nickname = "topic/content/sub/comment/pagination")
    @GetMapping(value = "topic/content/sub/comment/pagination")
    public PagerResponseDto topicContentSubCommentPagination() {

        return new PagerResponseDto();
    }

    @ApiOperation(value = "删除评论", nickname = "topic/content/comment/delete")
    @PostMapping(value = "topic/content/comment/delete")
    public ResponseDto topicContentCommentDelete() {

        return new ResponseDto();
    }


    /**
     * ----------------------------------------------------------------------------------------
     * 专题资源
     */

    @ApiOperation(value = "新增资源", nickname = "resource/add")
    @PostMapping(value = "resource/add")
    public ResponseDto resourceAdd(@Validated @RequestBody CircleResourceAddReq req) {
        platformCircleService.resourceAdd(req.getCircleId(), req.getTitle(), req.getIfEnable(), req.getContent());
        return new ResponseDto();
    }

    @ApiOperation(value = "编辑资源", nickname = "resource/update")
    @PostMapping(value = "resource/update")
    public ResponseDto resourceUpdate(@Validated @RequestBody CircleResourceUpdateReq req) {
        platformCircleService.resourceUpdate(req.getId(), req.getTitle(), req.getIfEnable(), req.getContent());
        return new ResponseDto();
    }

    @ApiOperation(value = "资源是否上架", nickname = "resource/enable")
    @PostMapping(value = "resource/enable")
    public ResponseDto resourceEnable(@Validated @RequestBody EnableReq req) {
        platformCircleService.resourceEnable(req.getId(), req.getIfEnable());
        return new ResponseDto();
    }

    @ApiOperation(value = "资源分页", nickname = "resource/pagination")
    @GetMapping(value = "resource/pagination")
    public PagerResponseDto<CircleResourcePagerRsp> resourcePagination(@Validated CircleResourcePagerReq req) {
        return new PagerResponseDto<>(platformCircleService.resourcePagination(req));
    }

    @ApiOperation(value = "圈子资源详情", nickname = "resource/detail")
    @GetMapping(value = "resource/detail")
    public ResponseDto<CircleResourceDetailRsp> resourceDetail(@Validated IdReq req) {
        return new ResponseDto<>(platformCircleService.resourceDetail(req.getId()));
    }
}
