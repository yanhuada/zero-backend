package com.yanhuada.platform.controller;

import com.yanhuada.common.model.ListResponseDto;
import com.yanhuada.common.model.ResponseDto;
import com.yanhuada.platform.model.admin.req.AdminAddReq;
import com.yanhuada.platform.model.admin.req.AdminLoginReq;
import com.yanhuada.platform.model.admin.rsp.AdminDetailRsp;
import com.yanhuada.platform.service.PlatformAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author yanhuada
 * CREATE ON 2020/8/10 18:20
 */
@Api(tags = "管理员相关接口")
@Validated
@RestController
@RequestMapping("/pf-api/admin")
public class AdminController {

    @Resource
    private PlatformAdminService platformAdminService;

    @ApiOperation(value = "新增管理员", nickname = "add")
    @PostMapping(value = "add")
    public ResponseDto add(@Validated @RequestBody AdminAddReq req) {
        platformAdminService.add(req.getName(), req.getPassword());
        return new ResponseDto();
    }

    @ApiOperation(value = "登陆", nickname = "login")
    @PostMapping(value = "login")
    public ResponseDto<AdminDetailRsp> login(@Validated @RequestBody AdminLoginReq req) {
        return new ResponseDto<>(platformAdminService.login(req.getName(), req.getPassword()));
    }

    @ApiOperation(value = "获取管理员信息", nickname = "detail")
    @GetMapping(value = "detail")
    public ResponseDto<AdminDetailRsp> detail() {
        return new ResponseDto<>(platformAdminService.detail());
    }


    @ApiOperation(value = "管理员列表", nickname = "list")
    @GetMapping(value = "list")
    public ListResponseDto list() {
        return new ListResponseDto();
    }

    @ApiOperation(value = "是否启用", nickname = "enable")
    @PostMapping(value = "enable")
    public ResponseDto enable() {
        return new ResponseDto();
    }

    @ApiOperation(value = "编辑管理员", nickname = "update")
    @PostMapping(value = "update")
    public ResponseDto update() {
        return new ResponseDto();
    }
}
