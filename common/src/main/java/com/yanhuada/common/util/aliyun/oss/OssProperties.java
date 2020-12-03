package com.yanhuada.common.util.aliyun.oss;

import lombok.Data;

/**
 * @author yanhuada
 * CREATE ON 2020/5/29 19:42
 */
@Data
public class OssProperties {

    private String accessKeyId;
    private String accessKeySecret;
    private String endpoint = "oss-cn-shenzhen.aliyuncs.com";
}
