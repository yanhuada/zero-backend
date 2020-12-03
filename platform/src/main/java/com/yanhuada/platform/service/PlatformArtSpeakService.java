package com.yanhuada.platform.service;

import com.yanhuada.common.model.Pager;
import com.yanhuada.platform.model.artspeak.req.ArtSpeakPagerReq;
import com.yanhuada.platform.model.artspeak.rsp.ArtSpeackPagerRsp;
import com.yanhuada.platform.model.artspeak.rsp.ArtSpeakTypeListRsp;
import com.yanhuada.service.BaseArtSpeakService;

import java.util.List;

/**
 * @author yanhuada
 * CREATE ON 2020/8/17 12:53
 */
public interface PlatformArtSpeakService extends BaseArtSpeakService {
    void typeAdd(String name, Integer sort, Boolean ifEnable);
    void typeUpdate(Long id, String name, Integer sort, Boolean ifEnable);
    void typeEnable(Long id, Boolean ifEnable);
    void typeSort(Long id, Integer sort);
    void typeDelete(Long id);
    List<ArtSpeakTypeListRsp> typeList(String name, Boolean ifEnable);
    void add(Long artSpeakTypeId, String content, Boolean ifEnable);
    void update(Long id, String content, Boolean ifEnable);
    void enable(Long id,Boolean ifEnable);
    void delete(Long id);
    Pager<ArtSpeackPagerRsp> pagination(ArtSpeakPagerReq req);
}
