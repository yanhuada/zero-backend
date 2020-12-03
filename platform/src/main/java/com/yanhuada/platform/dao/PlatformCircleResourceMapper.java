package com.yanhuada.platform.dao;

import com.yanhuada.common.model.PagerDto;
import com.yanhuada.dao.mapper.CircleResourceMapper;
import com.yanhuada.model.CircleResource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yanhuada
 * CREATE ON 2020/8/22 22:58
 */
public interface PlatformCircleResourceMapper extends CircleResourceMapper {

    List<CircleResource> list(@Param("circleId") Long circleId, @Param("title") String title,
                              @Param("ifEnable") Boolean ifEnable, @Param("page") PagerDto page);
    Long total(@Param("circleId") Long circleId, @Param("title") String title,
               @Param("ifEnable") Boolean ifEnable);
}
