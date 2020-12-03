package com.yanhuada.client.controller;

import com.yanhuada.client.service.ClientSmsService;
import com.yanhuada.common.model.CaptchaType;
import com.yanhuada.common.model.ResponseDto;
import com.yanhuada.common.validator.Phone;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.Max;

/**
 * @author yanhuada
 * CREATE ON 2020/8/9 21:15
 */
@Api(tags = "信息相关接口")
@Validated
@RestController
@RequestMapping("/api/sms")
public class SmsController {

    @Resource
    private ClientSmsService clientSmsService;

    @ApiOperation(value = "发送手机登陆验证码", nickname = "phone/login/captcha/send")
    @GetMapping(value = "phone/login/captcha/send")
    public ResponseDto<String> phoneLoginCaptchaSend(@Phone(message = "手机号格式不正确") String phone) {
        String captcha = clientSmsService.phoneCaptchaSend(CaptchaType.PHONE_LOGIN, "+86", phone);
        return new ResponseDto<>(captcha);
    }

    @ApiOperation(value = "验证手机登陆验证码", nickname = "phone/login/captcha/check")
    @PostMapping(value = "phone/login/captcha/check")
    public ResponseDto phoneLoginCaptchaCheck(@RequestParam(value = "phone") @Phone(message = "手机号格式不正确") String phone,
                                         @RequestParam(value = "captcha") @Max(value = 4, message = "验证码格式不正确") String captcha) {
        clientSmsService.phoneCaptchaCheck(CaptchaType.PHONE_LOGIN, "+86", phone, captcha);
        return new ResponseDto();
    }
}
