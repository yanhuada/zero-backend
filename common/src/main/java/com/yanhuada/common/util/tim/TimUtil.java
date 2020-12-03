package com.yanhuada.common.util.tim;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yanhuada
 * CREATE ON 2020/8/25 12:09
 */
public class TimUtil {

    private static final long sdkappid = 1400409567;
    private static final String identifier = "administrator";
    private static final String key = "f333c8351a3ca58738f3bf60aa4b7796be5a9502ec2ee8ab016c5cc4d3b3b245";
    private static final String url = "https://console.tim.qq.com/v4/openim/sendmsg?";

    public void send(String toAccount, String msgContent) {
        try {
            String usersig = new TLSSigAPIv2(sdkappid, key).genUserSig(identifier, 30000);
            Integer msgRandom = Integer.parseInt(RandomStringUtils.randomNumeric(8));
            String toUrl = url + "sdkappid=" + sdkappid + "&identifier=" + identifier + "&usersig=" + usersig + "&random=" + msgRandom + "&contenttype=json";
            Integer msgTimeStamp = Math.toIntExact(LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8")));

            JSONObject requestParams = new JSONObject();
            requestParams.put("SyncOtherMachine", 2);
            requestParams.put("To_Account", toAccount);
            requestParams.put("MsgLifeTime", 60);
            requestParams.put("MsgRandom",msgRandom);
            requestParams.put("MsgTimeStamp", msgTimeStamp);

            JSONArray msgBodyArr = new JSONArray();
            JSONObject msgBody = new JSONObject();
            JSONObject msgBodyContent = new JSONObject();
            msgBodyContent.put("Text", msgContent);
            msgBody.put("MsgType", "TIMTextElem");
            msgBody.put("MsgContent", msgBodyContent);
            msgBodyArr.add(msgBody);

            requestParams.put("MsgBody", msgBodyArr);

            RestTemplate template = new RestTemplate();

            HttpHeaders headers = new HttpHeaders();
            MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
            headers.setContentType(type);
            headers.add("Accept", MediaType.APPLICATION_JSON.toString());
            HttpEntity<String> formEntity = new HttpEntity<String>(requestParams.toString(), headers);

            String s = template.postForEntity(toUrl, formEntity, String.class).getBody();
            System.out.println(s);

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }


}
