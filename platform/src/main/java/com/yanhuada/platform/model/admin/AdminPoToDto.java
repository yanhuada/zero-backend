package com.yanhuada.platform.model.admin;

import com.yanhuada.model.Admin;
import com.yanhuada.platform.model.admin.rsp.AdminDetailRsp;

/**
 * @author yanhuada
 * CREATE ON 2020/8/10 19:02
 */
public class AdminPoToDto {
    public static AdminDetailRsp copyAdminDetailRsp(Admin admin) {
        AdminDetailRsp rsp = new AdminDetailRsp();
        rsp.setId(admin.getId());
        rsp.setName(admin.getName());
        rsp.setEmail(admin.getEmail());
        rsp.setIfSuper(admin.getIfSuper());
        rsp.setPhone(admin.getPhone());
        return rsp;
    }
}
