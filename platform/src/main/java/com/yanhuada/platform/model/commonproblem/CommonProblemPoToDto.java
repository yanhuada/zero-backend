package com.yanhuada.platform.model.commonproblem;

import com.yanhuada.model.CommonProblem;
import com.yanhuada.platform.model.commonproblem.rsp.CommonProblemListRsp;

/**
 * @author yanhuada
 * CREATE ON 2020/8/27 18:14
 */
public class CommonProblemPoToDto {

    public static CommonProblemListRsp copyCommonProblemListRsp(CommonProblem commonProblem){
        CommonProblemListRsp rsp = new CommonProblemListRsp();
        rsp.setId(commonProblem.getId());
        rsp.setTitle(commonProblem.getTitle());
        rsp.setContent(commonProblem.getContent());
        rsp.setIfEnable(commonProblem.getIfEnable());
        return rsp;
    }
}
