package com.yanhuada.dao.mapper;

import com.yanhuada.model.ArtSpeakRecord;
import com.yanhuada.model.ArtSpeakRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArtSpeakRecordMapper {
    long countByExample(ArtSpeakRecordExample example);

    int deleteByExample(ArtSpeakRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ArtSpeakRecord record);

    int insertSelective(ArtSpeakRecord record);

    List<ArtSpeakRecord> selectByExample(ArtSpeakRecordExample example);

    ArtSpeakRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ArtSpeakRecord record, @Param("example") ArtSpeakRecordExample example);

    int updateByExample(@Param("record") ArtSpeakRecord record, @Param("example") ArtSpeakRecordExample example);

    int updateByPrimaryKeySelective(ArtSpeakRecord record);

    int updateByPrimaryKey(ArtSpeakRecord record);
}