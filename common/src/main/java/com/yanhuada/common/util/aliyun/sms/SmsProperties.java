package com.yanhuada.common.util.aliyun.sms;

import com.aliyuncs.http.MethodType;
import lombok.Data;

/**
 * @author yanhuada
 * CREATE ON 2020/3/23 0:21
 */
@Data
public class SmsProperties {
    private String accessKeyId;
    private String accessSecret;
    private String regionId;
    private String signName;
    private String templateCode;
    private final MethodType methodType = MethodType.POST;
    private final String domain = "dysmsapi.aliyuncs.com";
    private final String version = "2017-05-25";
    private final String action = "SendSms";
}
