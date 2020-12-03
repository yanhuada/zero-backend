package com.yanhuada.service.impl;

import com.yanhuada.dao.mapper.BannerMapper;
import com.yanhuada.exception.CommonException;
import com.yanhuada.exception.ErrorCode;
import com.yanhuada.model.Banner;
import com.yanhuada.service.BaseBannerService;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author yanhuada
 * CREATE ON 2020/8/10 17:45
 */
public class BaseBannerServiceImpl implements BaseBannerService {
    @Resource
    private BannerMapper bannerMapper;

    @Override
    public Banner findById(Long id) {
        return bannerMapper.selectByPrimaryKey(id);
    }

    @Override
    public Banner findByIdOrFail(Long id) {
        return Optional.ofNullable(findById(id)).orElseThrow(() -> new CommonException(ErrorCode.BANNER_NOT_FOUND));
    }
}
