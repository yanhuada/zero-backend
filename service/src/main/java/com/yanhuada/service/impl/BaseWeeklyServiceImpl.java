package com.yanhuada.service.impl;

import com.yanhuada.dao.mapper.WeeklyMapper;
import com.yanhuada.exception.CommonException;
import com.yanhuada.exception.ErrorCode;
import com.yanhuada.model.Weekly;
import com.yanhuada.service.BaseWeeklyService;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author yanhuada
 * CREATE ON 2020/8/10 17:43
 */
public class BaseWeeklyServiceImpl implements BaseWeeklyService {

    @Resource
    private WeeklyMapper weeklyMapper;

    @Override
    public Weekly findById(Long id) {
        return weeklyMapper.selectByPrimaryKey(id);
    }

    @Override
    public Weekly findByIdOrFail(Long id) {
        return Optional.ofNullable(findById(id)).orElseThrow(()->new CommonException(ErrorCode.WEEKLY_NOT_FOUND));
    }
}
