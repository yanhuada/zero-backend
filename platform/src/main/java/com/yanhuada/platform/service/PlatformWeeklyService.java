package com.yanhuada.platform.service;

import com.yanhuada.common.enumeration.WeeklyStatus;
import com.yanhuada.common.model.Pager;
import com.yanhuada.platform.model.weekly.req.WeeklyAddReq;
import com.yanhuada.platform.model.weekly.req.WeeklyPagerReq;
import com.yanhuada.platform.model.weekly.req.WeeklyUpdateReq;
import com.yanhuada.platform.model.weekly.rsp.WeeklyDetailRsp;
import com.yanhuada.platform.model.weekly.rsp.WeeklyPagerRsp;
import com.yanhuada.service.BaseWeeklyService;

/**
 * @author yanhuada
 * CREATE ON 2020/8/13 17:47
 */
public interface PlatformWeeklyService extends BaseWeeklyService {

    /**
     * 周刊新增
     *
     * @param req 新增参数
     */
    void add(WeeklyAddReq req);

    /**
     * 周刊新增
     *
     * @param req 编辑参数
     */
    void update(WeeklyUpdateReq req);

    /**
     * 修改周刊状态
     *
     * @param id           id
     * @param weeklyStatus 状态
     */
    void updateStatus(Long id, WeeklyStatus weeklyStatus);

    /**
     * 删除周刊
     *
     * @param id ID
     */
    void delete(Long id);

    /**
     * 周刊分页
     *
     * @param req 分页请求参数
     * @return 分页
     */
    Pager<WeeklyPagerRsp> pagination(WeeklyPagerReq req);

    /**
     * 详情
     *
     * @param id ID
     * @return 周刊详情
     */
    WeeklyDetailRsp detail(Long id);
}
