package com.yanhuada.client.service;

import com.yanhuada.common.model.CaptchaType;

/**
 * @author yanhuada
 * CREATE ON 2020/8/9 19:13
 */
public interface ClientSmsService {

    /**
     * 发送手机验证码
     *
     * @param captchaType 验证码类型
     * @param prefix      手机前缀
     * @param phone       手机号
     * @return 返回验证码
     */
    String phoneCaptchaSend(CaptchaType captchaType, String prefix, String phone);

    /**
     * 验证手机验证码
     *
     * @param captchaType 验证码类型
     * @param prefix      手机前缀
     * @param phone       手机号
     * @param captcha     验证码
     */
    void phoneCaptchaCheck(CaptchaType captchaType, String prefix, String phone, String captcha);
}
