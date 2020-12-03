package com.yanhuada.dao.mapper;

import com.yanhuada.model.ArtSpeak;
import com.yanhuada.model.ArtSpeakExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArtSpeakMapper {
    long countByExample(ArtSpeakExample example);

    int deleteByExample(ArtSpeakExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ArtSpeak record);

    int insertSelective(ArtSpeak record);

    List<ArtSpeak> selectByExample(ArtSpeakExample example);

    ArtSpeak selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ArtSpeak record, @Param("example") ArtSpeakExample example);

    int updateByExample(@Param("record") ArtSpeak record, @Param("example") ArtSpeakExample example);

    int updateByPrimaryKeySelective(ArtSpeak record);

    int updateByPrimaryKey(ArtSpeak record);
}