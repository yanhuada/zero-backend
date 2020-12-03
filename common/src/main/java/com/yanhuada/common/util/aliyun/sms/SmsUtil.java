package com.yanhuada.common.util.aliyun.sms;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author yanhuada
 * CREATE ON 2020/3/23 0:20
 */
@Data
public class SmsUtil {

    private SmsProperties properties;

    public SmsUtil(SmsProperties properties){
        this.properties = properties;
    }

    public void send(String phoneNumbers,String captcha){
        DefaultProfile profile = DefaultProfile.getProfile(properties.getRegionId(), properties.getAccessKeyId(), properties.getAccessSecret());
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain(properties.getDomain());
        request.setSysVersion(properties.getVersion());
        request.setSysAction(properties.getAction());
        request.putQueryParameter("RegionId", properties.getRegionId());
        request.putQueryParameter("PhoneNumbers", phoneNumbers);
        request.putQueryParameter("SignName", properties.getSignName());
        request.putQueryParameter("TemplateCode", properties.getTemplateCode());
        request.putQueryParameter("TemplateParam", JSON.toJSONString(new Code(captcha)));
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
    @Data
    @AllArgsConstructor
    class Code{
        private String code;
    }
}
