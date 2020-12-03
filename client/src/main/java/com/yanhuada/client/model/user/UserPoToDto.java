package com.yanhuada.client.model.user;

import com.yanhuada.client.model.user.rsp.UserLoginRsp;
import com.yanhuada.common.util.aliyun.oss.OssUtil;
import com.yanhuada.model.User;

/**
 * @author yanhuada
 * CREATE ON 2020/8/8 15:08
 */
public class UserPoToDto {

    public static UserLoginRsp copyUserLoginRsp(User user, OssUtil ossUtil) {
        UserLoginRsp rsp = new UserLoginRsp();
        rsp.setId(user.getId());
        rsp.setAvatar(ossUtil.getFileUrl(user.getAvatar()));
        rsp.setEmail(user.getEmail());
        rsp.setNickname(user.getNickname());
        rsp.setPhone(user.getPhone());
        rsp.setLocation(user.getLocation());
        return rsp;
    }
}
