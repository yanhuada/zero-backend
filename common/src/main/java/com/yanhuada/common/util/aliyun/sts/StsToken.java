package com.yanhuada.common.util.aliyun.sts;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.http.ProtocolType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.aliyuncs.sts.model.v20150401.AssumeRoleRequest;
import com.aliyuncs.sts.model.v20150401.AssumeRoleResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author yanhuada
 * CREATE ON 2020/3/19 16:38
 */
public class StsToken {

    Logger logger = LoggerFactory.getLogger(StsToken.class);

    private StsProperties properties;

    public StsToken(StsProperties properties) {
        this.properties = properties;
    }

    public AssumeRoleResponse get() {
        try {
            logger.info("accessKeyId: {}，accessKeySecret: {}" ,properties.getAccessKeyId(),properties.getAccessKeySecret());
            logger.info("endpoint:{}，roleArn:{}，policy:{}",properties.getStsEndpoint(),properties.getRoleArn(),properties.getPolicy());

            //构造default profile（参数留空，无需添加Region ID）
            IClientProfile profile = DefaultProfile.getProfile("", properties.getAccessKeyId(), properties.getAccessKeySecret());
            //用profile构造client
            DefaultAcsClient client = new DefaultAcsClient(profile);
            final AssumeRoleRequest request = new AssumeRoleRequest();
            request.setSysEndpoint(properties.getStsEndpoint());
            request.setSysMethod(MethodType.POST);
            request.setRoleArn(properties.getRoleArn());
            request.setRoleSessionName(properties.getRoleSessionName());
            request.setPolicy(properties.getPolicy());
            request.setSysProtocol(ProtocolType.HTTPS);
            request.setDurationSeconds(1200L);
            final AssumeRoleResponse response = client.getAcsResponse(request);

            return response;
        } catch (ClientException e) {
            throw new StsException(e.getMessage(), e);
        }
    }
}
