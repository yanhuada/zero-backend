package com.yanhuada.platform.dao;

import com.yanhuada.common.model.PagerDto;
import com.yanhuada.dao.mapper.UserMapper;
import com.yanhuada.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yanhuada
 * CREATE ON 2020/8/12 14:51
 */
public interface PlatformUserMapper extends UserMapper {

    /**
     * 查询用户列表
     *
     * @param phone             手机号码
     * @param nickname          昵称
     * @param ifCustomerService 是否是客服
     * @param ifAuthor          是否是作者
     * @param ifEnable          是否启用
     * @param pagerDto          分页参数
     * @return 用户列表
     */
    List<User> list(@Param("phone") String phone, @Param("nickname") String nickname, @Param("ifCustomerService")
            Boolean ifCustomerService, @Param("ifAuthor") Boolean ifAuthor, @Param("ifEnable") Boolean ifEnable,
                    @Param("page") PagerDto pagerDto);

    /**
     * 查询用户数量
     *
     * @param phone             手机号码
     * @param nickname          昵称
     * @param ifCustomerService 是否是客服
     * @param ifAuthor          是否是作者
     * @param ifEnable          是否启用
     * @return 数量
     */
    Long total(@Param("phone") String phone, @Param("nickname") String nickname, @Param("ifCustomerService")
            Boolean ifCustomerService, @Param("ifAuthor") Boolean ifAuthor, Boolean ifEnable);
}
