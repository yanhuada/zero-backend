package com.yanhuada.platform.dao;

import com.yanhuada.common.model.PagerDto;
import com.yanhuada.dao.mapper.WeeklyMapper;
import com.yanhuada.model.Weekly;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yanhuada
 * CREATE ON 2020/8/14 14:07
 */
public interface PlatformWeeklyMapper extends WeeklyMapper {
    /**
     * 查询周刊列表
     *
     * @param authorId      作者ID
     * @param title         标题
     * @param publishStatus 发布状态
     * @param page          分页参数
     * @return 列表
     */
    List<Weekly> list(@Param("authorId") Long authorId, @Param("title") String title,
                      @Param("publishStatus") Integer publishStatus, @Param("page") PagerDto page);

    /**
     * 查询周刊数量
     *
     * @param authorId      作者ID
     * @param title         标题
     * @param publishStatus 发布状态
     * @return 数量
     */
    Long total(@Param("authorId") Long authorId, @Param("title") String title,
               @Param("publishStatus") Integer publishStatus);
}

