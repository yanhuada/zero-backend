package com.yanhuada.client.dao;

import com.yanhuada.dao.mapper.ArtSpeakRecordMapper;
import com.yanhuada.model.ArtSpeakRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yanhuada
 * CREATE ON 2020/8/18 14:25
 */
public interface ClientArtSpeakRecordMapper extends ArtSpeakRecordMapper {

    void batchInsert(@Param("artSpeakRecordList") List<ArtSpeakRecord> artSpeakRecordList);
}
