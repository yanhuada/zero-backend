package com.yanhuada.service;

import com.yanhuada.model.ArtSpeak;
import com.yanhuada.model.ArtSpeakType;

/**
 * @author yanhuada
 * CREATE ON 2020/8/10 17:40
 */
public interface BaseArtSpeakService {

    ArtSpeak findById(Long id);
    ArtSpeak findByIdOrFail(Long id);
    ArtSpeakType findTypeById(Long id);
    ArtSpeakType findTypeByIdOrFail(Long id);
}
