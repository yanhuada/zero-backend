package com.yanhuada.platform.service;

import com.yanhuada.platform.model.banner.rsp.BannerListRsp;
import com.yanhuada.service.BaseBannerService;

import java.util.List;

/**
 * @author yanhuada
 * CREATE ON 2020/8/18 10:40
 */
public interface PlatformBannerService extends BaseBannerService {

    /**
     * 新增banner
     *
     * @param title    标题
     * @param imageKey 图片key
     * @param link     跳转链接
     * @param sort     顺序
     * @param ifEnable 是否为空
     */
    void add(String title, String imageKey, String link, Integer sort, Boolean ifEnable);

    /**
     * 修改Banner
     *
     * @param id       ID
     * @param title    标题
     * @param imageKey 图片key
     * @param link     跳转链接
     * @param sort     顺序
     * @param ifEnable 是否为空
     */
    void update(Long id, String title, String imageKey, String link, Integer sort, Boolean ifEnable);

    /**
     * 修改顺序
     *
     * @param id   ID
     * @param sort 顺序
     */
    void sort(Long id, Integer sort);

    /**
     * 设置是否为空
     *
     * @param id     ID
     * @param enable 是否为空
     */
    void enable(Long id, Boolean enable);

    /**
     * banner列表
     *
     * @return 返回列表
     */
    List<BannerListRsp> list();

    /**
     * 删除banner
     *
     * @param id ID
     */
    void delete(Long id);
}
