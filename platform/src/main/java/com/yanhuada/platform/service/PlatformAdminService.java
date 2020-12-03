package com.yanhuada.platform.service;

import com.yanhuada.platform.model.admin.rsp.AdminDetailRsp;

/**
 * @author yanhuada
 * CREATE ON 2020/8/10 18:39
 */
public interface PlatformAdminService {

    /**
     * 管理员登陆
     *
     * @param name     管理员名称
     * @param password 密码
     * @return 返回管理员详情
     */
    AdminDetailRsp login(String name, String password);

    /**
     * 新增管理员
     *
     * @param name     名称
     * @param password 密码
     */
    void add(String name, String password);

    /**
     * 管理员详情
     *
     * @return 返回详情
     */
    AdminDetailRsp detail();
}
