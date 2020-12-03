package com.yanhuada.client.service;

import com.yanhuada.client.model.artspeak.req.ArtSpeakPagerReq;
import com.yanhuada.client.model.artspeak.rsp.ArtSpeakPagerRsp;
import com.yanhuada.client.model.artspeak.rsp.ArtSpeakTypeListRsp;
import com.yanhuada.common.model.Pager;
import com.yanhuada.service.BaseArtSpeakService;

import java.util.List;

/**
 * @author yanhuada
 * CREATE ON 2020/8/18 13:52
 */
public interface ClientArtSpeakService extends BaseArtSpeakService {
    List<ArtSpeakTypeListRsp> typeList();

    Pager<ArtSpeakPagerRsp> pagination(ArtSpeakPagerReq req);

    void artSpeakRecordBatchInsert(Long userId, List<Long> artSpeakIdList);
}
