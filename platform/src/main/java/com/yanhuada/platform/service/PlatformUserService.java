package com.yanhuada.platform.service;

import com.yanhuada.common.model.Pager;
import com.yanhuada.platform.model.user.req.UserPagerReq;
import com.yanhuada.platform.model.user.rsp.UserAuthorRsp;
import com.yanhuada.platform.model.user.rsp.UserDetailRsp;
import com.yanhuada.platform.model.user.rsp.UserPagerRsp;
import com.yanhuada.service.BaseUserService;

import java.util.List;

/**
 * @author yanhuada
 * CREATE ON 2020/8/10 18:17
 */
public interface PlatformUserService extends BaseUserService {

    /**
     * 分页查询
     *
     * @param req 参数
     * @return 用户分页列表
     */
    Pager<UserPagerRsp> pagination(UserPagerReq req);

    /**
     * 是否启用
     *
     * @param id       ID
     * @param ifEnable true||false
     */
    void enable(Long id, boolean ifEnable);

    /**
     * 用户详情
     *
     * @param id ID
     * @return 详情
     */
    UserDetailRsp detail(Long id);

    /**
     * 作者列表
     *
     * @return list
     */
    List<UserAuthorRsp> authorList();

    /**
     * 设置用户为作者
     *
     * @param userId 用户ID
     */
    void authorSet(Long userId);

    /**
     * 删除作者
     *
     * @param userId 用户ID
     */
    void authorDelete(Long userId);

    /**
     * 设置为客服
     *
     * @param userId 用户ID
     */
    void customerServiceSet(Long userId);
}
