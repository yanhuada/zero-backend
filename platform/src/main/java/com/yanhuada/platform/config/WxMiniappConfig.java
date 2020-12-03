package com.yanhuada.platform.config;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.impl.WxMaServiceImpl;
import cn.binarywang.wx.miniapp.config.impl.WxMaDefaultConfigImpl;
import com.yanhuada.common.util.webchat.miniapp.MiniappUtil;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yanhuada
 * CREATE ON 2020/3/22 23:07
 */
@Data
@Configuration
@ConfigurationProperties(ignoreUnknownFields = false, prefix = "wechat.miniapp")
public class WxMiniappConfig {

    /**
     * 设置微信小程序的appid
     */
    private String appid;

    /**
     * 设置微信小程序的Secret
     */
    private String secret;

    @Bean
    public MiniappUtil miniappUtil(){
        WxMaDefaultConfigImpl config = new WxMaDefaultConfigImpl();
        config.setAppid(appid);
        config.setSecret(secret);
        WxMaService service = new WxMaServiceImpl();
        service.setWxMaConfig(config);
        return new MiniappUtil(service);
    }
}
