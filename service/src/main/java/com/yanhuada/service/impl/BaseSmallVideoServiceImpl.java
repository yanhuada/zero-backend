package com.yanhuada.service.impl;

import com.yanhuada.dao.mapper.SmallVideoMapper;
import com.yanhuada.exception.CommonException;
import com.yanhuada.exception.ErrorCode;
import com.yanhuada.model.SmallVideo;
import com.yanhuada.service.BaseSmallVideoService;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author yanhuada
 * CREATE ON 2020/8/10 17:40
 */
public class BaseSmallVideoServiceImpl implements BaseSmallVideoService {

    @Resource
    private SmallVideoMapper smallVideoMapper;

    @Override
    public SmallVideo findById(Long id) {
        return smallVideoMapper.selectByPrimaryKey(id);
    }

    @Override
    public SmallVideo findByIdOrFail(Long id) {
        return Optional.ofNullable(this.findById(id)).orElseThrow(()->new CommonException(ErrorCode.SMALL_VIDEO_NOT_FOUND));
    }
}
