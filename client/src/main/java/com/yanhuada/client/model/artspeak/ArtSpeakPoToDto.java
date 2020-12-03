package com.yanhuada.client.model.artspeak;

import com.yanhuada.client.model.artspeak.rsp.ArtSpeakPagerRsp;
import com.yanhuada.client.model.artspeak.rsp.ArtSpeakTypeListRsp;
import com.yanhuada.model.ArtSpeak;
import com.yanhuada.model.ArtSpeakRecord;
import com.yanhuada.model.ArtSpeakType;

/**
 * @author yanhuada
 * CREATE ON 2020/8/18 14:19
 */
public class ArtSpeakPoToDto {
    public static ArtSpeakTypeListRsp copyArtSpeakTypeListRsp(ArtSpeakType artSpeakType){
        ArtSpeakTypeListRsp rsp = new ArtSpeakTypeListRsp();
        rsp.setId(artSpeakType.getId());
        rsp.setName(artSpeakType.getName());
        return rsp;
    }

    public static ArtSpeakPagerRsp copyArtSpeakPagerRsp(ArtSpeak artSpeak, ArtSpeakRecord artSpeakRecord) {
        ArtSpeakPagerRsp rsp = new ArtSpeakPagerRsp();
        rsp.setId(artSpeak.getId());
        rsp.setContent(artSpeak.getContent());
        rsp.setLikeNum(artSpeak.getLikeNum());
        rsp.setDislikeNum(artSpeak.getDislikeNum());
        rsp.setAttitude(artSpeakRecord == null ? 0 : artSpeakRecord.getAttitude());
        return rsp;
    }
}
