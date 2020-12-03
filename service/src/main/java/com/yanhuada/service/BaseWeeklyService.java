package com.yanhuada.service;

import com.yanhuada.model.Weekly;

/**
 * @author yanhuada
 * CREATE ON 2020/8/10 17:43
 */
public interface BaseWeeklyService {
    Weekly findById(Long id);
    Weekly findByIdOrFail(Long id);
}
