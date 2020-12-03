package com.yanhuada.service;

import com.yanhuada.model.Banner;

/**
 * @author yanhuada
 * CREATE ON 2020/8/10 17:45
 */
public interface BaseBannerService {
    Banner findById(Long id);
    Banner findByIdOrFail(Long id);
}
