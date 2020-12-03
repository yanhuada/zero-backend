package com.yanhuada.service.impl;

import com.alibaba.fastjson.JSON;
import com.yanhuada.common.util.tim.TimUtil;
import com.yanhuada.dao.mapper.SystemMessageRecordMapper;
import com.yanhuada.model.SystemMessageRecord;
import com.yanhuada.service.BaseSystemMessageService;

import javax.annotation.Resource;

/**
 * @author yanhuada
 * CREATE ON 2020/8/10 17:44
 */
public class BaseSystemMessageServiceImpl implements BaseSystemMessageService {
    @Resource
    private SystemMessageRecordMapper systemMessageRecordMapper;

    @Override
    public void add(Long userId, Long systemMessageId, String systemMessageTitle, String systemMessageContent, String systemMessageUrl, String systemMessageUrlText) {
        SystemMessageRecord systemMessageRecordForAdd = new SystemMessageRecord();
        systemMessageRecordForAdd.setUserId(userId);
        systemMessageRecordForAdd.setSystemMessageId(systemMessageId);
        systemMessageRecordForAdd.setSystemMessageTitle(systemMessageTitle);
        systemMessageRecordForAdd.setSystemMessageContent(systemMessageContent);
        systemMessageRecordForAdd.setSystemMessageUrl(systemMessageUrl);
        systemMessageRecordForAdd.setSystemMessageUrlText(systemMessageUrlText);
        systemMessageRecordMapper.insertSelective(systemMessageRecordForAdd);

        TimUtil util = new TimUtil();
        util.send(userId.toString(), JSON.toJSONString(systemMessageRecordForAdd));
    }
}
