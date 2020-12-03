package com.yanhuada.platform.service;

import com.yanhuada.platform.model.commonproblem.rsp.CommonProblemListRsp;
import com.yanhuada.service.BaseCommonProblemService;

import java.util.List;

/**
 * @author yanhuada
 * CREATE ON 2020/8/27 18:05
 */
public interface PlatfromCommonProblemService extends BaseCommonProblemService {

    void add(String title,Boolean ifEnable,String content);
    void update(Long id,String title,Boolean ifEnable,String content);
    void enable(Long id,Boolean ifEnable);
    List<CommonProblemListRsp> list();
}
