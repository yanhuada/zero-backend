package com.yanhuada.service.impl;

import com.yanhuada.dao.mapper.ArtSpeakMapper;
import com.yanhuada.dao.mapper.ArtSpeakTypeMapper;
import com.yanhuada.exception.CommonException;
import com.yanhuada.exception.ErrorCode;
import com.yanhuada.model.ArtSpeak;
import com.yanhuada.model.ArtSpeakType;
import com.yanhuada.service.BaseArtSpeakService;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author yanhuada
 * CREATE ON 2020/8/10 17:40
 */
public class BaseArtSpeakServiceImpl implements BaseArtSpeakService {

    @Resource
    private ArtSpeakMapper artSpeakMapper;
    @Resource
    private ArtSpeakTypeMapper artSpeakTypeMapper;

    @Override
    public ArtSpeak findById(Long id) {
        return artSpeakMapper.selectByPrimaryKey(id);
    }

    @Override
    public ArtSpeak findByIdOrFail(Long id) {
        return Optional.ofNullable(findById(id)).orElseThrow(() -> new CommonException(ErrorCode.ART_SPEAK_NOT_FOUND));
    }

    @Override
    public ArtSpeakType findTypeById(Long id) {
        return artSpeakTypeMapper.selectByPrimaryKey(id);
    }

    @Override
    public ArtSpeakType findTypeByIdOrFail(Long id) {
        return Optional.ofNullable(findTypeById(id)).orElseThrow(() -> new CommonException(ErrorCode.ART_SPEAK_TYPE_NOT_FOUND));
    }
}
