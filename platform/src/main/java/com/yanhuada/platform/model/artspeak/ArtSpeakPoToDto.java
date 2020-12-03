package com.yanhuada.platform.model.artspeak;

import com.yanhuada.model.ArtSpeak;
import com.yanhuada.model.ArtSpeakType;
import com.yanhuada.platform.model.artspeak.rsp.ArtSpeackPagerRsp;
import com.yanhuada.platform.model.artspeak.rsp.ArtSpeakTypeListRsp;

/**
 * @author yanhuada
 * CREATE ON 2020/8/17 13:40
 */
public class ArtSpeakPoToDto {

    public static ArtSpeakTypeListRsp copyArtSpeakTypeListRsp(ArtSpeakType artSpeakType) {
        ArtSpeakTypeListRsp rsp = new ArtSpeakTypeListRsp();
        rsp.setId(artSpeakType.getId());
        rsp.setName(artSpeakType.getName());
        rsp.setIfEnable(artSpeakType.getIfEnable());
        rsp.setSort(artSpeakType.getSort());
        rsp.setCreatedAt(artSpeakType.getCreatedAt());
        return rsp;
    }

    public static ArtSpeackPagerRsp copyArtSpeackPagerRsp(ArtSpeak artSpeak) {
        ArtSpeackPagerRsp rsp = new ArtSpeackPagerRsp();
        rsp.setId(artSpeak.getId());
        rsp.setArtSpeakTypeId(artSpeak.getArtSpeakTypeId());
        rsp.setArtSpeakTypeName(artSpeak.getArtSpeakTypeName());
        rsp.setContent(artSpeak.getContent());
        rsp.setLikeNum(artSpeak.getLikeNum());
        rsp.setDislikeNum(artSpeak.getDislikeNum());
        rsp.setCreatedAt(artSpeak.getCreatedAt());
        rsp.setIfEnable(artSpeak.getIfEnable());
        return rsp;
    }
}
