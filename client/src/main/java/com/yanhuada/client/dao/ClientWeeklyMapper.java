package com.yanhuada.client.dao;

import com.yanhuada.common.model.PagerDto;
import com.yanhuada.dao.mapper.WeeklyMapper;
import com.yanhuada.model.Weekly;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yanhuada
 * CREATE ON 2020/8/16 19:36
 */
public interface ClientWeeklyMapper extends WeeklyMapper {
    List<Weekly> list(@Param("page") PagerDto page);
    Long total();
}
