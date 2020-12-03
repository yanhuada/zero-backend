package com.yanhuada.client.service.impl;

import com.yanhuada.client.dao.ClientSystemMessageRecordMapper;
import com.yanhuada.client.jwt.JwtSessionUtil;
import com.yanhuada.client.model.systemmessage.SystemMessagePoToDto;
import com.yanhuada.client.model.systemmessage.req.SystemMessagePagerReq;
import com.yanhuada.client.model.systemmessage.rsp.SystemMessageOverviewRsp;
import com.yanhuada.client.model.systemmessage.rsp.SystemMessagePagerRsp;
import com.yanhuada.client.service.ClientSystemMessageRecordService;
import com.yanhuada.common.model.Pager;
import com.yanhuada.common.model.SystemMessageType;
import com.yanhuada.model.Circle;
import com.yanhuada.model.SystemMessageRecord;
import com.yanhuada.model.User;
import com.yanhuada.service.impl.BaseSystemMessageServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author yanhuada
 * CREATE ON 2020/8/24 13:55
 */
@Service
public class ClientSystemMessageRecordServiceImpl extends BaseSystemMessageServiceImpl implements ClientSystemMessageRecordService {

    @Resource
    private ClientSystemMessageRecordMapper clientSystemMessageRecordMapper;
    @Resource
    private JwtSessionUtil jwtSessionUtil;
    @Resource
    private HttpServletRequest request;

    @Override
    public Pager<SystemMessagePagerRsp> pagination(SystemMessagePagerReq req) {
        Long userId = jwtSessionUtil.getUserIdFromAuthenticatedSession(request);

        Pager<SystemMessagePagerRsp> rspPager = new Pager<>(req.getPage(), req.getCount());

        Long total = clientSystemMessageRecordMapper.total(userId);
        rspPager.setTotal(Math.toIntExact(total));
        if (total == 0) {
            return rspPager;
        }

        List<SystemMessageRecord> systemMessageRecordList = clientSystemMessageRecordMapper.list(userId, req);

        rspPager.setArray(systemMessageRecordList.stream()
                .map(SystemMessagePoToDto::copySystemMessagePagerRsp)
                .collect(Collectors.toList()));

        //设置信息为已读
        this.setAllRead(userId);

        return rspPager;
    }

    @Override
    public SystemMessageOverviewRsp overview() {
        if (jwtSessionUtil.ifAnonymous(request)) {
            return SystemMessagePoToDto.copySystemMessageOverviewRsp(null, "", null, 0);
        }
        Long userId = jwtSessionUtil.getUserIdFromAuthenticatedSession(request);
        Long total = clientSystemMessageRecordMapper.noReadTotal(userId);

        SystemMessageRecord systemMessageRecord = Optional.of(clientSystemMessageRecordMapper.newest(userId)).orElseGet(() -> {
            SystemMessageRecord newInstance = new SystemMessageRecord();
            newInstance.setId(0L);
            newInstance.setSystemMessageTitle("");
            return newInstance;
        });

        return SystemMessagePoToDto.copySystemMessageOverviewRsp(
                systemMessageRecord.getId(), systemMessageRecord.getSystemMessageTitle(), systemMessageRecord.getCreatedAt(), Math.toIntExact(total));

    }

    @Override
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void sendJoinCircleMessage(User user, Circle circle) {
        SystemMessageType systemMessageType = SystemMessageType.JION_CIRCLE;
        String title = StringUtils.replace(systemMessageType.getTitle(), "${circleName}", circle.getName());
        String content = StringUtils.replace(systemMessageType.getContent(), "${circleName}", circle.getName());
        String url = StringUtils.replace(systemMessageType.getUrl(), "${id}", circle.getId().toString());
        String urlText = systemMessageType.getUrlText();
        super.add(user.getId(), 0L, title, content, url, urlText);
    }

    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void setAllRead(Long userId) {
        clientSystemMessageRecordMapper.setAllRead(userId);
    }
}
