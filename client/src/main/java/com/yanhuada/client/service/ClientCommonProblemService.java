package com.yanhuada.client.service;

import com.yanhuada.client.model.commonproblem.rsp.CommonProblemDetailRsp;
import com.yanhuada.client.model.commonproblem.rsp.CommonProblemListRsp;
import com.yanhuada.service.BaseCommonProblemService;

import java.util.List;

/**
 * @author yanhuada
 * CREATE ON 2020/8/27 17:03
 */
public interface ClientCommonProblemService extends BaseCommonProblemService {

    List<CommonProblemListRsp> list();
    CommonProblemDetailRsp detail(Long id);
}
