package com.yanhuada.client.service;

import com.yanhuada.client.model.banner.rsp.BannerListRsp;
import com.yanhuada.service.BaseBannerService;

import java.util.List;

/**
 * @author yanhuada
 * CREATE ON 2020/8/10 17:48
 */
public interface ClientBannerService extends BaseBannerService {
    List<BannerListRsp> list();
}
