package com.yanhuada.client.service.impl;

import com.yanhuada.client.dao.ClientCommonProblemMapper;
import com.yanhuada.client.model.commonproblem.CommonProblemPoToDto;
import com.yanhuada.client.model.commonproblem.rsp.CommonProblemDetailRsp;
import com.yanhuada.client.model.commonproblem.rsp.CommonProblemListRsp;
import com.yanhuada.client.service.ClientCommonProblemService;
import com.yanhuada.model.CommonProblem;
import com.yanhuada.model.CommonProblemExample;
import com.yanhuada.service.impl.BaseCommonProblemServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yanhuada
 * CREATE ON 2020/8/27 17:04
 */
@Service
public class ClientCommonProblemServiceImpl extends BaseCommonProblemServiceImpl implements ClientCommonProblemService {

    @Resource
    private ClientCommonProblemMapper clientCommonProblemMapper;

    @Override
    public List<CommonProblemListRsp> list() {
        CommonProblemExample example = new CommonProblemExample();
        example.createCriteria().andIfEnableEqualTo(true);
        List<CommonProblem> commonProblemList = clientCommonProblemMapper.selectByExample(example);
        return commonProblemList.stream().map(CommonProblemPoToDto::copyCommonProblemListRsp).collect(Collectors.toList());
    }

    @Override
    public CommonProblemDetailRsp detail(Long id) {
        CommonProblem commonProblem = clientCommonProblemMapper.selectByPrimaryKey(id);
        return CommonProblemPoToDto.copyCommonProblemDetailRsp(commonProblem);
    }
}
