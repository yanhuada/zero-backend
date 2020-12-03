package com.yanhuada.platform.dao;

import com.yanhuada.dao.mapper.ArtSpeakTypeMapper;
import com.yanhuada.model.ArtSpeakType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yanhuada
 * CREATE ON 2020/8/14 14:30
 */
public interface PlatformArtSpeakTypeMapper extends ArtSpeakTypeMapper {
    ArtSpeakType findByName(@Param("name") String name);

    List<ArtSpeakType> list(@Param("name") String name, @Param("ifEnable") Boolean ifEnable);
}
