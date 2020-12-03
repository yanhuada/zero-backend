package com.yanhuada.client.service.impl;

import com.yanhuada.client.dao.ClientFeedbackMapper;
import com.yanhuada.client.jwt.JwtSessionUtil;
import com.yanhuada.client.service.ClientFeedbackService;
import com.yanhuada.client.service.ClientUserService;
import com.yanhuada.model.Feedback;
import com.yanhuada.model.User;
import com.yanhuada.service.impl.BaseFeedbackServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author yanhuada
 * CREATE ON 2020/8/27 17:17
 */
@Service
public class ClientFeedbackServiceImpl extends BaseFeedbackServiceImpl implements ClientFeedbackService {

    @Resource
    private ClientFeedbackMapper clientFeedbackMapper;
    @Resource
    private ClientUserService clientUserService;
    @Resource
    private JwtSessionUtil jwtSessionUtil;
    @Resource
    private HttpServletRequest request;

    @Override
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void add(String content) {
        Long userId = jwtSessionUtil.getUserIdFromAuthenticatedSession(request);
        User user = clientUserService.findByIdFail(userId);

        Feedback feedbackForAdd = new Feedback();
        feedbackForAdd.setUserId(user.getId());
        feedbackForAdd.setContent(content);
        feedbackForAdd.setIfHandle(false);
        feedbackForAdd.setUserNickname(user.getNickname());
        feedbackForAdd.setUserAvatar(user.getAvatar());

        clientFeedbackMapper.insertSelective(feedbackForAdd);
    }
}
