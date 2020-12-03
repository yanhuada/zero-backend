package com.yanhuada.common.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author yanhuada
 * CREATE ON 2020/8/21 14:59
 */
@Data
@ApiModel(value = "")
public class EnableReq {
    @NotNull(message = "id不能为空")
    public Long id;
    @NotNull(message = "是否启用不能为空")
    @ApiModelProperty(value = "是否启用")
    private Boolean ifEnable;
}
