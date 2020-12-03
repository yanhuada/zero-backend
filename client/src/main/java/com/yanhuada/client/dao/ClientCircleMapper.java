package com.yanhuada.client.dao;

import com.yanhuada.dao.mapper.CircleMapper;
import com.yanhuada.model.Circle;

import java.util.List;

/**
 * @author yanhuada
 * CREATE ON 2020/8/21 17:41
 */
public interface ClientCircleMapper extends CircleMapper {

    List<Circle> hotList();

}
