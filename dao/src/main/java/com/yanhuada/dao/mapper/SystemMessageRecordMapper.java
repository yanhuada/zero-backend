package com.yanhuada.dao.mapper;

import com.yanhuada.model.SystemMessageRecord;
import com.yanhuada.model.SystemMessageRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystemMessageRecordMapper {
    long countByExample(SystemMessageRecordExample example);

    int deleteByExample(SystemMessageRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SystemMessageRecord record);

    int insertSelective(SystemMessageRecord record);

    List<SystemMessageRecord> selectByExample(SystemMessageRecordExample example);

    SystemMessageRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SystemMessageRecord record, @Param("example") SystemMessageRecordExample example);

    int updateByExample(@Param("record") SystemMessageRecord record, @Param("example") SystemMessageRecordExample example);

    int updateByPrimaryKeySelective(SystemMessageRecord record);

    int updateByPrimaryKey(SystemMessageRecord record);
}