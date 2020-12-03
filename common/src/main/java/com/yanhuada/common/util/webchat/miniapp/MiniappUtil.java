package com.yanhuada.common.util.webchat.miniapp;

import cn.binarywang.wx.miniapp.api.WxMaQrcodeService;
import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.WxMaUserService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaPhoneNumberInfo;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import com.yanhuada.common.util.webchat.exception.WxException;
import lombok.AllArgsConstructor;
import me.chanjar.weixin.common.error.WxErrorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * @author yanhuada
 * CREATE ON 2020/3/22 22:51
 */
@AllArgsConstructor
public class MiniappUtil {

    private static final Logger logger = LoggerFactory.getLogger(MiniappUtil.class);

    private WxMaService wxMaService;

    public WxMaUserInfo getWxUserInfo(MiniappInfoReq req) {
        WxMaUserService wxMaUserService = wxMaService.getUserService();

        // 获取小程序用户信息
        WxMaJscode2SessionResult sessionInfo;
        try {
            sessionInfo = wxMaUserService.getSessionInfo(req.getCode());
        } catch (WxErrorException e) {
            logger.warn("[ 微信获取用户信息失败 ] ----->，错误信息：{},{}", e.getMessage(), e.getCause());
            throw new WxException("微信获取用户信息失败");
        }
        if (!wxMaUserService.checkUserInfo(sessionInfo.getSessionKey(), req.getRawData(), req.getSignature())) {
            logger.warn("验签微信加密数据不一致:sessionKey:{} rawData:{} signature:{}", sessionInfo.getSessionKey(), req.getRawData(), req.getSignature());
            throw new WxException("验签微信加密数据不一致");
        }

        WxMaUserInfo userInfo = wxMaUserService.getUserInfo(sessionInfo.getSessionKey(), req.getEncryptedData(), req.getIv());
        logger.info("小程序获取到的用户信息是{}", userInfo);
        return userInfo;
    }

    public String getWxacode(String scene) {

        WxMaQrcodeService wxMaQrcodeService = wxMaService.getQrcodeService();
        File file = null;
        try {
            file = wxMaQrcodeService.createWxaCodeUnlimit(scene, null);
        } catch (WxErrorException e) {
            logger.warn("[获取小程序码失败]，错误信息：{}，{}", e.getMessage(), e.getCause());
        }
        return file.getPath();
    }
}
