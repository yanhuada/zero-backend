package com.yanhuada.client.service;

import com.yanhuada.client.model.systemmessage.req.SystemMessagePagerReq;
import com.yanhuada.client.model.systemmessage.rsp.SystemMessageOverviewRsp;
import com.yanhuada.client.model.systemmessage.rsp.SystemMessagePagerRsp;
import com.yanhuada.common.model.Pager;
import com.yanhuada.model.Circle;
import com.yanhuada.model.User;
import com.yanhuada.service.BaseSystemMessageService;

/**
 * @author yanhuada
 * CREATE ON 2020/8/24 13:54
 */
public interface ClientSystemMessageRecordService extends BaseSystemMessageService {

    Pager<SystemMessagePagerRsp> pagination(SystemMessagePagerReq req);

    void sendJoinCircleMessage(User user, Circle circle);

    SystemMessageOverviewRsp overview();
}
