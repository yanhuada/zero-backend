package com.yanhuada.platform.controller;

import com.yanhuada.common.model.IdReq;
import com.yanhuada.common.model.ListResponseDto;
import com.yanhuada.common.model.PagerResponseDto;
import com.yanhuada.common.model.ResponseDto;
import com.yanhuada.platform.model.user.req.UserEnableReq;
import com.yanhuada.platform.model.user.req.UserPagerReq;
import com.yanhuada.platform.model.user.rsp.UserAuthorRsp;
import com.yanhuada.platform.model.user.rsp.UserDetailRsp;
import com.yanhuada.platform.model.user.rsp.UserPagerRsp;
import com.yanhuada.platform.service.PlatformUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author yanhuada
 * CREATE ON 2020/8/10 18:20
 */
@Api(tags = "用户相关接口")
@Validated
@RestController
@RequestMapping("/pf-api/user")
public class UserController {

    @Resource
    private PlatformUserService platformUserService;

    @ApiOperation(value = "用户分页", nickname = "pagination")
    @GetMapping(value = "pagination")
    public PagerResponseDto<UserPagerRsp> pagination(@Validated UserPagerReq req) {
        return new PagerResponseDto<>(platformUserService.pagination(req));
    }

    @ApiOperation(value = "用户详情", nickname = "detail")
    @GetMapping(value = "detail")
    public ResponseDto<UserDetailRsp> detail(@Validated IdReq req) {
        return new ResponseDto<>(platformUserService.detail(req.getId()));
    }

    @ApiOperation(value = "是否启用", nickname = "enable")
    @PostMapping(value = "enable")
    public ResponseDto enable(@Validated @RequestBody UserEnableReq req) {
        platformUserService.enable(req.getId(), req.getEnable());
        return new ResponseDto();
    }

    @ApiOperation(value = "设置为作者", nickname = "author/set")
    @PostMapping(value = "author/set")
    public ResponseDto authorSet(@Validated @RequestBody IdReq req) {
        platformUserService.authorSet(req.getId());
        return new ResponseDto();
    }

    @ApiOperation(value = "删除作者", nickname = "author/delete")
    @PostMapping(value = "author/delete")
    public ResponseDto authorDelete(@Validated @RequestBody IdReq req) {
        platformUserService.authorDelete(req.getId());
        return new ResponseDto();
    }

    @ApiOperation(value = "作者列表", nickname = "author/list")
    @GetMapping(value = "author/list")
    public ListResponseDto<UserAuthorRsp> authorList() {
        return new ListResponseDto<>(platformUserService.authorList());
    }

    @ApiOperation(value = "设置为客服", nickname = "customer/service/set")
    @PostMapping(value = "customer/service/set")
    public ResponseDto customerServiceSet(@Validated @RequestBody IdReq req) {
        platformUserService.customerServiceSet(req.getId());
        return new ResponseDto();
    }

    @ApiOperation(value = "客服列表", nickname = "customer/service/list")
    @GetMapping(value = "customer/service/list")
    public ListResponseDto customerServiceList() {

        return new ListResponseDto();
    }
}
