package com.yanhuada.service;

import com.yanhuada.model.SmallVideo;

/**
 * @author yanhuada
 * CREATE ON 2020/8/10 17:40
 */
public interface BaseSmallVideoService  {
    SmallVideo findById(Long id);
    SmallVideo findByIdOrFail(Long id);
}
