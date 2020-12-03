package com.yanhuada.client.dao;

import com.yanhuada.common.model.PagerDto;
import com.yanhuada.dao.mapper.CircleTopicContentMapper;
import com.yanhuada.model.CircleTopicContent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yanhuada
 * CREATE ON 2020/8/21 17:42
 */
public interface ClientCircleTopicContentMapper extends CircleTopicContentMapper {

    List<CircleTopicContent> list(@Param("circleTopicId") Long circleTopicId, @Param("page") PagerDto page);
    Long total(@Param("circleTopicId") Long circleTopicId);
}
