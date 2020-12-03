package com.yanhuada.client.service;

import com.yanhuada.client.model.weekly.req.WeeklyPagerReq;
import com.yanhuada.client.model.weekly.rsp.WeeklyDetailRsp;
import com.yanhuada.client.model.weekly.rsp.WeeklyPagerRsp;
import com.yanhuada.common.model.Pager;
import com.yanhuada.service.BaseWeeklyService;

/**
 * @author yanhuada
 * CREATE ON 2020/8/16 19:33
 */
public interface ClientWeeklyService extends BaseWeeklyService {

    /**
     * 周刊分页
     *
     * @param req 分页请求参数
     * @return 周刊列表
     */
    Pager<WeeklyPagerRsp> pagination(WeeklyPagerReq req);

    /**
     * 周刊详情
     *
     * @param id ID
     * @return 详情
     */
    WeeklyDetailRsp detail(Long id);
}
