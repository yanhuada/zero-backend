package com.yanhuada.platform.dao;

import com.yanhuada.dao.mapper.AdminMapper;
import com.yanhuada.model.Admin;
import org.apache.ibatis.annotations.Param;

/**
 * @author yanhuada
 * CREATE ON 2020/8/10 18:50
 */
public interface PlatformAdminMapper extends AdminMapper {

    /**
     * 根据名称查询管理员
     *
     * @param name 名称
     * @return admin
     */
    Admin findByName(@Param("name") String name);
}
