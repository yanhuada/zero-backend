package com.yanhuada.common.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author yanhuada
 * CREATE ON 2020/3/18 18:05
 */
@Data
public class IdReq {

    @NotNull(message = "id不能为空")
    public Long id;
}
