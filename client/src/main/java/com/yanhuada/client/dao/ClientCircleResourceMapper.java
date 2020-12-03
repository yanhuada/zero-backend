package com.yanhuada.client.dao;

import com.yanhuada.common.model.PagerDto;
import com.yanhuada.dao.mapper.CircleResourceMapper;
import com.yanhuada.model.CircleResource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yanhuada
 * CREATE ON 2020/8/22 22:26
 */
public interface ClientCircleResourceMapper extends CircleResourceMapper {

    List<CircleResource> list(@Param("circleId") Long circleId, @Param("page") PagerDto page);

    Long total(@Param("circleId") Long circleId);
}
