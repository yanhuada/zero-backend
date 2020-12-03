package com.yanhuada.client.dao;

import com.yanhuada.dao.mapper.UserMapper;
import com.yanhuada.model.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author yanhuada
 * CREATE ON 2020/8/8 14:12
 */
public interface ClientUserMapper extends UserMapper {

    /**
     * 通过openid查询用户
     * @param openId 微信OPENID
     * @return user
     */
    User selectByOpenId(@Param("openId") String openId);

    /**
     * 通过手机号查询用户
     * @param phone 手机号
     * @return user
     */
    User selectByPhone(@Param("phone") String phone);
}
