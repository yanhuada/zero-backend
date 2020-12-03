package com.yanhuada.platform.model.banner;

import com.yanhuada.common.util.aliyun.oss.OssUtil;
import com.yanhuada.model.Banner;
import com.yanhuada.platform.model.banner.rsp.BannerListRsp;

/**
 * @author yanhuada
 * CREATE ON 2020/8/18 11:05
 */
public class BannerPoToDto {

    public static BannerListRsp copyBannerListRsp(Banner banner, OssUtil ossUtil) {
        BannerListRsp rsp = new BannerListRsp();
        rsp.setId(banner.getId());
        rsp.setTitle(banner.getTitle());
        rsp.setSort(banner.getSort());
        rsp.setLink(banner.getLink());
        rsp.setImageKey(banner.getImageKey());
        rsp.setImageUrl(ossUtil.getFileUrl(banner.getImageKey()));
        rsp.setIfEnable(banner.getIfEnable());
        rsp.setCreatedAt(banner.getCreatedAt());
        return rsp;
    }
}
