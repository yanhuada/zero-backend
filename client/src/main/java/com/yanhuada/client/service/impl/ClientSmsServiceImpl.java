package com.yanhuada.client.service.impl;

import com.yanhuada.client.jwt.JwtSessionUtil;
import com.yanhuada.client.service.ClientSmsService;
import com.yanhuada.common.model.CaptchaType;
import com.yanhuada.common.util.aliyun.sms.SmsUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.function.Supplier;

/**
 * @author yanhuada
 * CREATE ON 2020/8/9 19:19
 */
@Service
public class ClientSmsServiceImpl implements ClientSmsService {


    @Resource
    private JwtSessionUtil jwtSessionUtil;
    @Resource
    private HttpServletRequest request;
    @Resource
    private SmsUtil smsUtil;

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientSmsServiceImpl.class);

    private static final Supplier<String> CAPTCHA = () -> RandomStringUtils.randomNumeric(4);

    private static final String KEY_PREFIX = "CAPTCHA_";

    @Override
    public String phoneCaptchaSend(CaptchaType captchaType, String prefix, String phone) {
        String captcha = CAPTCHA.get();
        String key = KEY_PREFIX + captchaType.getCode() + prefix + phone;
        jwtSessionUtil.cacheCaptcha(jwtSessionUtil.getSession(request), key, captcha);
//        smsUtil.send(phone, captcha);
        LOGGER.info("发送手机验证码");
        LOGGER.info("手机号为：{} \n 手机验证码：{}", prefix + phone, captcha);
        return captcha;
    }

    @Override
    public void phoneCaptchaCheck(CaptchaType captchaType, String prefix, String phone, String captcha) {
        String key = KEY_PREFIX + captchaType.getCode() + prefix + phone;
        LOGGER.info("key值：{} \n 验证码：{}", key, captcha);
        jwtSessionUtil.verifyCaptcha(jwtSessionUtil.getSession(request), key, captcha);
        LOGGER.info("手机验证码校验成功");
    }
}
