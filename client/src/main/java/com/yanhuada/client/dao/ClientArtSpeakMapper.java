package com.yanhuada.client.dao;

import com.yanhuada.common.model.PagerDto;
import com.yanhuada.model.ArtSpeak;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yanhuada
 * CREATE ON 2020/8/18 13:54
 */
public interface ClientArtSpeakMapper {

    List<ArtSpeak> list( @Param("artSpeakTypeId") Long artSpeakTypeId, @Param("page") PagerDto page);

    Long total(@Param("artSpeakTypeId") Long artSpeakTypeId);
}
