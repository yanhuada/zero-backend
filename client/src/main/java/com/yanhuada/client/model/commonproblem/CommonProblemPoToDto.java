package com.yanhuada.client.model.commonproblem;

import com.yanhuada.client.model.commonproblem.rsp.CommonProblemDetailRsp;
import com.yanhuada.client.model.commonproblem.rsp.CommonProblemListRsp;
import com.yanhuada.model.CommonProblem;

/**
 * @author yanhuada
 * CREATE ON 2020/8/27 17:06
 */
public class CommonProblemPoToDto {

    public static CommonProblemListRsp copyCommonProblemListRsp(CommonProblem commonProblem) {
        CommonProblemListRsp rsp = new CommonProblemListRsp();
        rsp.setId(commonProblem.getId());
        rsp.setTitle(commonProblem.getTitle());
        return rsp;
    }

    public static CommonProblemDetailRsp copyCommonProblemDetailRsp(CommonProblem commonProblem) {
        CommonProblemDetailRsp rsp = new CommonProblemDetailRsp();
        rsp.setId(commonProblem.getId());
        rsp.setTitle(commonProblem.getTitle());
        rsp.setContent(commonProblem.getContent());
        return rsp;
    }
}
