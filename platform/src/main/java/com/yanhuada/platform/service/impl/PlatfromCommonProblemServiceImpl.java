package com.yanhuada.platform.service.impl;

import com.yanhuada.exception.CommonException;
import com.yanhuada.exception.ErrorCode;
import com.yanhuada.model.CommonProblem;
import com.yanhuada.model.CommonProblemExample;
import com.yanhuada.platform.dao.PlatformCommonProblemMapper;
import com.yanhuada.platform.model.commonproblem.CommonProblemPoToDto;
import com.yanhuada.platform.model.commonproblem.rsp.CommonProblemListRsp;
import com.yanhuada.platform.service.PlatfromCommonProblemService;
import com.yanhuada.service.impl.BaseCommonProblemServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author yanhuada
 * CREATE ON 2020/8/27 18:06
 */
@Service
public class PlatfromCommonProblemServiceImpl extends BaseCommonProblemServiceImpl implements PlatfromCommonProblemService {

    @Resource
    private PlatformCommonProblemMapper platformCommonProblemMapper;

    @Override
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void add(String title, Boolean ifEnable, String content) {
        CommonProblem commonProblemForAdd = new CommonProblem();
        commonProblemForAdd.setTitle(title);
        commonProblemForAdd.setContent(content);
        commonProblemForAdd.setIfEnable(ifEnable);

        platformCommonProblemMapper.insertSelective(commonProblemForAdd);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void update(Long id, String title, Boolean ifEnable, String content) {
        CommonProblem commonProblem = Optional.ofNullable(platformCommonProblemMapper.selectByPrimaryKey(id)).orElseThrow(() -> new CommonException(ErrorCode.COMMON_PROBLEM_NOT_FOUND));
        commonProblem.setTitle(title);
        commonProblem.setContent(content);
        commonProblem.setIfEnable(ifEnable);

        platformCommonProblemMapper.updateByPrimaryKeySelective(commonProblem);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void enable(Long id, Boolean ifEnable) {
        CommonProblem commonProblem = Optional.ofNullable(platformCommonProblemMapper.selectByPrimaryKey(id)).orElseThrow(() -> new CommonException(ErrorCode.COMMON_PROBLEM_NOT_FOUND));
        commonProblem.setIfEnable(ifEnable);
        platformCommonProblemMapper.updateByPrimaryKeySelective(commonProblem);
    }

    @Override
    public List<CommonProblemListRsp> list() {
        CommonProblemExample example = new CommonProblemExample();
        List<CommonProblem> commonProblemList = platformCommonProblemMapper.selectByExample(example);
        return commonProblemList.stream().map(CommonProblemPoToDto::copyCommonProblemListRsp).collect(Collectors.toList());
    }
}
