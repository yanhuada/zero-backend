package com.yanhuada.platform.dao;

import com.yanhuada.common.model.PagerDto;
import com.yanhuada.dao.mapper.CircleMapper;
import com.yanhuada.model.Circle;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yanhuada
 * CREATE ON 2020/8/12 18:46
 */
public interface PlatformCircleMapper extends CircleMapper {

    /**
     * 根据名称查询圈子
     *
     * @param name 名称
     * @return 返回圈子对象
     */
    Circle findByName(@Param("name") String name);

    /**
     * 查询圈子列表
     *
     * @param name     名称
     * @param ifEnable 是否启动
     * @param pagerDto 分页请求参数
     * @return 圈子列表
     */
    List<Circle> list(@Param("name") String name, @Param("ifEnable") Boolean ifEnable, @Param("page") PagerDto pagerDto);

    /**
     * 数量
     *
     * @param name     名称
     * @param ifEnable 是否启动
     * @return 数量
     */
    Long total(@Param("name") String name, @Param("ifEnable") Boolean ifEnable);
}
