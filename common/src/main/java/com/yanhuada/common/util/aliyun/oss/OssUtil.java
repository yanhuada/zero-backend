package com.yanhuada.common.util.aliyun.oss;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.GenericRequest;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.SimplifiedObjectMeta;

/**
 * @author yanhuada
 * CREATE ON 2020/5/29 19:40
 */
public class OssUtil {
    private static final String BUCKET_NAME = "vardar";

    private OssProperties properties;
    private OSS ossClient;

    public OssUtil(OssProperties properties) {
        this.properties = properties;
        this.ossClient = new OSSClientBuilder().build(properties.getEndpoint(), properties.getAccessKeyId(), properties.getAccessKeySecret());
    }

    public String getFileUrl(String key) {
        return "https://".concat(BUCKET_NAME).concat(".").concat(properties.getEndpoint().concat("/").concat(key));
    }

    public String getFileSize(String key) {
        SimplifiedObjectMeta objectMeta = ossClient.getSimplifiedObjectMeta(BUCKET_NAME, key);
        return objectMeta.getSize() + "";
    }

    public void removeFile(String key) {
        OSSObject ossObject = ossClient.getObject(BUCKET_NAME, key);
        // 删除文件。;
        ossClient.deleteObject(BUCKET_NAME, key);
    }


}
