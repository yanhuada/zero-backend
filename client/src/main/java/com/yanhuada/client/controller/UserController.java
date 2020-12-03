package com.yanhuada.client.controller;

import com.yanhuada.client.model.user.req.UserAvatarUpdateReq;
import com.yanhuada.client.model.user.req.UserNicknameUpdateReq;
import com.yanhuada.client.model.user.req.UserPhoneLoginReq;
import com.yanhuada.client.model.user.rsp.UserLoginRsp;
import com.yanhuada.client.service.ClientUserService;
import com.yanhuada.common.model.ResponseDto;
import com.yanhuada.common.util.webchat.miniapp.MiniappInfoReq;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author yanhuada
 * CREATE ON 2020/8/8 13:57
 */

@Api(tags = "用户相关接口")
@Validated
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Resource
    private ClientUserService clientUserService;

    @ApiOperation(value = "微信小程序登陆", nickname = "miniapp/login")
    @PostMapping(value = "miniapp/login")
    public ResponseDto<UserLoginRsp> loginByMiniApp(@Validated @RequestBody MiniappInfoReq req) {
        return new ResponseDto<>(clientUserService.loginByMiniappLogin(req));
    }

    @ApiOperation(value = "手机号码登陆", nickname = "phone/login")
    @PostMapping(value = "phone/login")
    public ResponseDto<UserLoginRsp> phoneLogin(@Validated @RequestBody UserPhoneLoginReq req) {
        return new ResponseDto<>(clientUserService.phoneLogin(req.getPhone(), req.getCaptcha()));
    }

    @ApiOperation(value = "获取当前登陆用户详情", nickname = "detail")
    @GetMapping(value = "detail")
    public ResponseDto<UserLoginRsp> detail() {
        return new ResponseDto<>(clientUserService.detail());
    }

    @ApiOperation(value = "更新头像", nickname = "avatar/update")
    @PostMapping(value = "avatar/update")
    public ResponseDto<UserLoginRsp> avatarUpdate(@Validated @RequestBody UserAvatarUpdateReq req) {
        return new ResponseDto<>(clientUserService.avatarUpdate(req.getAvatar()));
    }

    @ApiOperation(value = "更新头像", nickname = "nickname/update")
    @PostMapping(value = "nickname/update")
    public ResponseDto<UserLoginRsp> nicknameUpdate(@Validated @RequestBody UserNicknameUpdateReq req) {
        return new ResponseDto<>(clientUserService.nicknameUpdate(req.getNickname()));
    }
}
