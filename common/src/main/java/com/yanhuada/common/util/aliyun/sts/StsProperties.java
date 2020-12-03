package com.yanhuada.common.util.aliyun.sts;

import lombok.Data;

/**
 * @author yanhuada
 * CREATE ON 2020/3/19 16:43
 */

@Data
public class StsProperties {
    private String stsEndpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String roleArn;
    private String roleSessionName;
    private String policy = "{\n" +
            "    \"Version\": \"1\", \n" +
            "    \"Statement\": [\n" +
            "        {\n" +
            "            \"Action\": [\n" +
            "                \"oss:*\"\n" +
            "            ], \n" +
            "            \"Resource\": [\n" +
            "                \"acs:oss:*:*:*\" \n" +
            "            ], \n" +
            "            \"Effect\": \"Allow\"\n" +
            "        }\n" +
            "    ]\n" +
            "}";
}
