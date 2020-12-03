package com.yanhuada.service;



/**
 * @author yanhuada
 * CREATE ON 2020/8/10 17:44
 */
public interface BaseSystemMessageService {


    void add(Long userId, Long systemMessageId, String systemMessageTitle, String systemMessageContent,
             String systemMessageUrl, String systemMessageUrlText);

}
