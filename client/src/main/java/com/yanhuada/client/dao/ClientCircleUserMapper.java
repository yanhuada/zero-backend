package com.yanhuada.client.dao;

import com.yanhuada.common.model.PagerDto;
import com.yanhuada.dao.mapper.CircleUserMapper;
import com.yanhuada.model.CircleUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yanhuada
 * CREATE ON 2020/8/21 17:51
 */
public interface ClientCircleUserMapper extends CircleUserMapper {

    List<CircleUser> list(@Param("circleId") Long circleId, @Param("page") PagerDto page);

    Long total(@Param("circleId") Long circleId);
}
