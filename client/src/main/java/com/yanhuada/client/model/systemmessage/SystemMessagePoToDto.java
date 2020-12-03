package com.yanhuada.client.model.systemmessage;

import com.yanhuada.client.model.systemmessage.rsp.SystemMessageOverviewRsp;
import com.yanhuada.client.model.systemmessage.rsp.SystemMessagePagerRsp;
import com.yanhuada.model.SystemMessageRecord;

import java.time.LocalDateTime;

/**
 * @author yanhuada
 * CREATE ON 2020/8/24 15:17
 */
public class SystemMessagePoToDto {

    public static SystemMessagePagerRsp copySystemMessagePagerRsp(SystemMessageRecord systemMessageRecord) {
        SystemMessagePagerRsp rsp = new SystemMessagePagerRsp();
        rsp.setId(systemMessageRecord.getId());
        rsp.setSystemMessageTitle(systemMessageRecord.getSystemMessageTitle());
        rsp.setSystemMessageContent(systemMessageRecord.getSystemMessageContent());
        rsp.setSystemMessageUrl(systemMessageRecord.getSystemMessageUrl());
        rsp.setSystemMessageUrlText(systemMessageRecord.getSystemMessageUrlText());
        rsp.setCreatedAt(systemMessageRecord.getCreatedAt());
        return rsp;
    }

    public static SystemMessageOverviewRsp copySystemMessageOverviewRsp(Long id, String systemMessageTitle, LocalDateTime createdAt, Integer count) {
        SystemMessageOverviewRsp rsp = new SystemMessageOverviewRsp();
        rsp.setId(id);
        rsp.setSystemMessageTitle(systemMessageTitle);
        rsp.setCreatedAt(createdAt);
        rsp.setCount(count);
        return rsp;
    }
}
