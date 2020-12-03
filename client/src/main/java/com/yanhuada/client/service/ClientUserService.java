package com.yanhuada.client.service;

import com.yanhuada.client.model.user.rsp.UserLoginRsp;
import com.yanhuada.common.model.CaptchaType;
import com.yanhuada.common.util.webchat.miniapp.MiniappInfoReq;
import com.yanhuada.service.BaseUserService;

/**
 * @author yanhuada
 * CREATE ON 2020/8/8 14:07
 */
public interface ClientUserService extends BaseUserService {

    /**
     * 微信小程序登陆
     *
     * @param req 相关参数
     * @return 用户信息
     */
    UserLoginRsp loginByMiniappLogin(MiniappInfoReq req);

    /**
     * 手机号登录
     *
     * @param phone   手机号
     * @param captcha 验证码
     * @return 用户信息
     */
    UserLoginRsp phoneLogin(String phone, String captcha);

    /**
     * 当前登陆用户详情
     *
     * @return 用户信息
     */
    UserLoginRsp detail();

    UserLoginRsp avatarUpdate(String avatar);

    UserLoginRsp nicknameUpdate(String nickname);

}
