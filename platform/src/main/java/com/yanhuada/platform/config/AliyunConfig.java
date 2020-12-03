package com.yanhuada.platform.config;

import com.yanhuada.common.util.aliyun.oss.OssProperties;
import com.yanhuada.common.util.aliyun.oss.OssUtil;
import com.yanhuada.common.util.aliyun.sms.SmsProperties;
import com.yanhuada.common.util.aliyun.sms.SmsUtil;
import com.yanhuada.common.util.aliyun.sts.StsProperties;
import com.yanhuada.common.util.aliyun.sts.StsToken;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yanhuada
 * CREATE ON 2020/3/23 0:42
 */
@Data
@Configuration
@ConfigurationProperties(ignoreUnknownFields = true, prefix = "aliyun")
public class AliyunConfig {

    private String accessKeyId;
    private String accessKeySecret;
    private String smsRegionId;
    private String smsSignName;
    private String smsTemplateCode;

    private String stsEndpoint;
    private String roleArn;
    private String roleSessionName;

    @Bean
    public SmsUtil smsUtil(){
        SmsProperties properties = new SmsProperties();
        properties.setAccessKeyId(accessKeyId);
        properties.setAccessSecret(accessKeySecret);
        properties.setRegionId(smsRegionId);
        properties.setSignName(smsSignName);
        properties.setTemplateCode(smsTemplateCode);
        return new SmsUtil(properties);
    }

    @Bean
    public StsToken stsToken() {
        StsProperties properties = new StsProperties();
        properties.setAccessKeyId(accessKeyId);
        properties.setAccessKeySecret(accessKeySecret);
        properties.setStsEndpoint(stsEndpoint);
        properties.setRoleSessionName(roleSessionName);
        properties.setRoleArn(roleArn);
        return new StsToken(properties);
    }

    @Bean
    public OssUtil ossUtil(){
        OssProperties properties = new OssProperties();
        properties.setAccessKeyId(accessKeyId);
        properties.setAccessKeySecret(accessKeySecret);
        return new OssUtil(properties);
    }
}
