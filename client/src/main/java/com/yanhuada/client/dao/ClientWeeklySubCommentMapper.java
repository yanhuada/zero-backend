package com.yanhuada.client.dao;

import com.yanhuada.common.model.PagerDto;
import com.yanhuada.dao.mapper.WeeklySubCommentMapper;
import com.yanhuada.model.WeeklySubComment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yanhuada
 * CREATE ON 2020/9/3 22:06
 */
public interface ClientWeeklySubCommentMapper extends WeeklySubCommentMapper {
    Long total(@Param("weekly_comment_id") Long weeklyCommentId);

    List<WeeklySubComment> list(@Param("weekly_comment_id") Long weeklyCommentId, @Param("page") PagerDto page);
}
