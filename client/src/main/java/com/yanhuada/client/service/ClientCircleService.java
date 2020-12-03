package com.yanhuada.client.service;

import com.yanhuada.client.model.circle.req.CircleResourcePagerReq;
import com.yanhuada.client.model.circle.req.CircleTopicContentPagerReq;
import com.yanhuada.client.model.circle.req.CircleUserPagerReq;
import com.yanhuada.client.model.circle.rsp.*;
import com.yanhuada.common.model.Pager;
import com.yanhuada.service.BaseCircleService;

import java.util.List;

/**
 * @author yanhuada
 * CREATE ON 2020/8/10 17:38
 */
public interface ClientCircleService extends BaseCircleService {

    List<CircleListRsp> hotList();

    List<CircleListRsp> mineList();

    List<CircleListRsp> otherList();

    CircleDetailRsp detail(Long id);

    void join(Long id);

    List<CircleTopicListRsp> topicList(Long circleId);

    Pager<CircleTopicContentPagerRsp> topicContentPagination(CircleTopicContentPagerReq req);

    CircleTopicContentDetailRsp topicContentDetail(Long topicContentId);

    Pager<CircleResourcePagerRsp> resourcePagination(CircleResourcePagerReq req);

    CircleResourceDetailRsp resourceDetail(Long id);

    Pager<CircleUserListRsp> userPagination(CircleUserPagerReq req);
}
