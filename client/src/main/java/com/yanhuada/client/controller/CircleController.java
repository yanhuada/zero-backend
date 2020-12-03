package com.yanhuada.client.controller;

import com.yanhuada.client.model.circle.req.CircleResourcePagerReq;
import com.yanhuada.client.model.circle.req.CircleTopicContentPagerReq;
import com.yanhuada.client.model.circle.req.CircleUserPagerReq;
import com.yanhuada.client.model.circle.rsp.*;
import com.yanhuada.client.service.ClientCircleService;
import com.yanhuada.common.model.IdReq;
import com.yanhuada.common.model.ListResponseDto;
import com.yanhuada.common.model.PagerResponseDto;
import com.yanhuada.common.model.ResponseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author yanhuada
 * CREATE ON 2020/8/10 17:34
 */
@Api(tags = "圈子相关接口")
@Validated
@RestController
@RequestMapping("/api/circle")
public class CircleController {

    @Resource
    private ClientCircleService clientCircleService;

    @ApiOperation(value = "热门圈子", nickname = "list/hot")
    @GetMapping(value = "hot/list")
    public ListResponseDto<CircleListRsp> hotList() {
        return new ListResponseDto<>(clientCircleService.hotList());
    }

    @ApiOperation(value = "我的圈子", nickname = "list/mine")
    @GetMapping(value = "mine/list")
    public ListResponseDto<CircleListRsp> mineList() {
        return new ListResponseDto<>(clientCircleService.mineList());
    }

    @ApiOperation(value = "其他圈子", nickname = "list/other")
    @GetMapping(value = "other/list")
    public ListResponseDto<CircleListRsp> otherList() {
        return new ListResponseDto<>(clientCircleService.otherList());
    }

    @ApiOperation(value = "圈子详情", nickname = "detail")
    @GetMapping(value = "detail")
    public ResponseDto<CircleDetailRsp> detail(@Validated IdReq req) {
        return new ResponseDto<>(clientCircleService.detail(req.getId()));
    }

    @ApiOperation(value = "join", nickname = "join")
    @PostMapping(value = "join")
    public ResponseDto join(@Validated @RequestBody IdReq req) {
        clientCircleService.join(req.getId());
        return new ResponseDto();
    }

    @ApiOperation(value = "专题列表", nickname = "topic/list")
    @GetMapping(value = "topic/list")
    public ListResponseDto<CircleTopicListRsp> topicList(@Validated IdReq req) {
        return new ListResponseDto<>(clientCircleService.topicList(req.getId()));
    }

    @ApiOperation(value = "专题内容分页", nickname = "topic/content/pagination")
    @GetMapping(value = "topic/content/pagination")
    public PagerResponseDto<CircleTopicContentPagerRsp> topicContentPagination(@Validated CircleTopicContentPagerReq req) {
        return new PagerResponseDto<>(clientCircleService.topicContentPagination(req));
    }

    @ApiOperation(value = "专题内容详情", nickname = "topic/content/detail")
    @GetMapping(value = "topic/content/detail")
    public ResponseDto<CircleTopicContentDetailRsp> topicContentDetail(@Validated IdReq req) {
        return new ResponseDto<>(clientCircleService.topicContentDetail(req.id));
    }

    @ApiOperation(value = "圈子资源分页列表", nickname = "resource/pagination")
    @GetMapping(value = "resource/pagination")
    public PagerResponseDto<CircleResourcePagerRsp> resourcePagination(@Validated CircleResourcePagerReq req) {
        return new PagerResponseDto<>(clientCircleService.resourcePagination(req));
    }

    @ApiOperation(value = "圈子资源详情", nickname = "resource/detail")
    @GetMapping(value = "resource/detail")
    public ResponseDto<CircleResourceDetailRsp> resourceDetail(@Validated IdReq req) {
        return new ResponseDto<>(clientCircleService.resourceDetail(req.getId()));
    }

    @ApiOperation(value = "圈子用户列表", nickname = "user/pagination")
    @GetMapping(value = "user/pagination")
    public PagerResponseDto<CircleUserListRsp> userPagination(@Validated CircleUserPagerReq req) {
        return new PagerResponseDto<>(clientCircleService.userPagination(req));
    }


}
