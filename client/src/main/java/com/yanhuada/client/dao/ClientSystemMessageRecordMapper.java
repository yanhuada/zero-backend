package com.yanhuada.client.dao;

import com.yanhuada.common.model.PagerDto;
import com.yanhuada.dao.mapper.SystemMessageRecordMapper;
import com.yanhuada.model.SystemMessageRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yanhuada
 * CREATE ON 2020/8/24 15:10
 */
public interface ClientSystemMessageRecordMapper extends SystemMessageRecordMapper {

    List<SystemMessageRecord> list(@Param("userId") Long userId, @Param("page") PagerDto page);

    Long total(@Param("userId") Long userId);

    Long noReadTotal(@Param("userId") Long userId);

    SystemMessageRecord newest(@Param("userId") Long userId);

    void setAllRead(@Param("userId") Long userId);
}
