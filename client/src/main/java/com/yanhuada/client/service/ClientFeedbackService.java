package com.yanhuada.client.service;

import com.yanhuada.service.BaseFeedbackService;

/**
 * @author yanhuada
 * CREATE ON 2020/8/27 17:17
 */
public interface ClientFeedbackService extends BaseFeedbackService {

    void add(String content);
}
