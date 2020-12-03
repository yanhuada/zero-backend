package com.yanhuada.client.model.banner;

import com.yanhuada.client.model.banner.rsp.BannerListRsp;
import com.yanhuada.common.util.aliyun.oss.OssUtil;
import com.yanhuada.model.Banner;

/**
 * @author yanhuada
 * CREATE ON 2020/8/18 13:12
 */
public class BannerPoToDto {
    public static BannerListRsp copyBannerListRsp(Banner banner, OssUtil ossUtil){
        BannerListRsp rsp = new BannerListRsp();
        rsp.setId(banner.getId());
        rsp.setTitle(banner.getTitle());
        rsp.setLink(banner.getLink());
        rsp.setImageUrl(ossUtil.getFileUrl(banner.getImageKey()));
        return rsp;
    }
}
