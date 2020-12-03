package com.yanhuada.platform.service;

import com.yanhuada.common.model.Pager;
import com.yanhuada.platform.model.circle.req.CirclePagerReq;
import com.yanhuada.platform.model.circle.req.CircleResourcePagerReq;
import com.yanhuada.platform.model.circle.req.CircleTopicContentPagerReq;
import com.yanhuada.platform.model.circle.rsp.*;
import com.yanhuada.service.BaseCircleService;

import java.util.List;

/**
 * @author yanhuada
 * CREATE ON 2020/8/12 18:09
 */
public interface PlatformCircleService extends BaseCircleService {

    /**
     * 新增圈子
     *
     * @param name      圈子名称
     * @param icon      圈子图标
     * @param cover     圈子封面图
     * @param introduce 圈子介绍
     */
    void add(String name, String icon, String cover, String introduce);

    /**
     * 圈子分页查询
     *
     * @param req 过滤参数
     * @return 返回列表
     */
    Pager<CirclePagerRsp> pagination(CirclePagerReq req);

    /**
     * 圈子列表
     *
     * @param name 圈子名称
     * @return 列表
     */
    List<CirclePagerRsp> list(String name);

    /**
     * 圈子详情
     *
     * @param id ID
     * @return 圈子详情
     */
    CircleDetailRsp detail(Long id);

    /**
     * 圈子上架下架
     *
     * @param id       ID
     * @param ifEnable 是否上架
     */
    void enable(Long id, Boolean ifEnable);


    /**
     * 新增专题
     *
     * @param circleId 圈子ID
     * @param name     名称
     * @param sort     顺序
     */
    void topicAdd(Long circleId, String name, Integer sort);

    /**
     * 编辑专题
     *
     * @param id   ID
     * @param name 名称
     * @param sort 顺序
     */
    void topicUpdate(Long id, String name, Integer sort);

    /**
     * 圈子专题列表
     *
     * @param circleId      圈子ID
     * @param name          圈子专题名称
     * @param publishStatus 状态
     * @return 专题列表
     */
    List<CircleTopicListRsp> topicList(Long circleId, String name, Integer publishStatus);

    /**
     * 圈子主题上架下架
     *
     * @param id       ID
     * @param ifEnable 是否上架
     */
    void topicEnable(Long id, Boolean ifEnable);

    /**
     * 新增主题内容
     *
     * @param circleTopicId 圈子主题ID
     * @param author        作者
     * @param title         标题
     * @param content       内容
     */
    void topicContentAdd(Long circleTopicId, String author, String title, String content);

    /**
     * 修改主题内容
     *
     * @param id      内容ID
     * @param author  作者
     * @param title   标题
     * @param content 内容
     */
    void topicContentUpdate(Long id, String author, String title, String content);

    /**
     * 专题内容分页
     *
     * @param req req
     * @return 分页列表
     */
    Pager<CircleTopicContentPagerRsp> topicContentPagination(CircleTopicContentPagerReq req);

    /**
     * 专题内容详情
     *
     * @param id ID
     * @return 详情
     */
    CircleTopicContentDetailRsp topicContentDetail(Long id);

    /**
     * 圈子主题内容上架下架
     *
     * @param id       ID
     * @param ifEnable 是否上架
     */
    void topicContentEnable(Long id, Boolean ifEnable);


    /**
     * 圈子自愿新增
     *
     * @param circleId 圈子id
     * @param title    标题
     * @param ifEnable 是否启动
     * @param content  内容
     */
    void resourceAdd(Long circleId, String title, Boolean ifEnable, String content);

    /**
     * 圈子资源修改
     *
     * @param id       圈子资源id
     * @param title    标题
     * @param ifEnable 是否启动
     * @param content  内容
     */
    void resourceUpdate(Long id, String title, Boolean ifEnable, String content);

    /**
     * 圈子资源是否启动
     *
     * @param id       圈子资源id
     * @param ifEnable 是否启动 true | false
     */
    void resourceEnable(Long id, Boolean ifEnable);


    /**
     * 圈子资源分页
     *
     * @param req 分页请求参数
     * @return 分页
     */
    Pager<CircleResourcePagerRsp> resourcePagination(CircleResourcePagerReq req);

    /**
     * 圈子资源详情
     *
     * @param id 圈子资源ID
     * @return 详情
     */
    CircleResourceDetailRsp resourceDetail(Long id);
}
