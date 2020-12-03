package com.yanhuada.dao.mapper;

import com.yanhuada.model.ArtSpeakType;
import com.yanhuada.model.ArtSpeakTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArtSpeakTypeMapper {
    long countByExample(ArtSpeakTypeExample example);

    int deleteByExample(ArtSpeakTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ArtSpeakType record);

    int insertSelective(ArtSpeakType record);

    List<ArtSpeakType> selectByExample(ArtSpeakTypeExample example);

    ArtSpeakType selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ArtSpeakType record, @Param("example") ArtSpeakTypeExample example);

    int updateByExample(@Param("record") ArtSpeakType record, @Param("example") ArtSpeakTypeExample example);

    int updateByPrimaryKeySelective(ArtSpeakType record);

    int updateByPrimaryKey(ArtSpeakType record);
}