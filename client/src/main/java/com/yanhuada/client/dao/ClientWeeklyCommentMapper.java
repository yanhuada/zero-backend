package com.yanhuada.client.dao;

import com.yanhuada.common.model.PagerDto;
import com.yanhuada.dao.mapper.WeeklyCommentMapper;
import com.yanhuada.model.WeeklyComment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yanhuada
 * CREATE ON 2020/9/3 22:06
 */
public interface ClientWeeklyCommentMapper extends WeeklyCommentMapper {
    Long total(@Param("weeklyId") Long weeklyId);

    List<WeeklyComment> list(@Param("weeklyId") Long weeklyId, @Param("page") PagerDto page);
}
