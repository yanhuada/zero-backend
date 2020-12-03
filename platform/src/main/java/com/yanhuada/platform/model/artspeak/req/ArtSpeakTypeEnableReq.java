package com.yanhuada.platform.model.artspeak.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author yanhuada
 * CREATE ON 2020/8/17 15:40
 */
@Data
@ApiModel
public class ArtSpeakTypeEnableReq {
    @NotNull(message = "id不能为空")
    public Long id;
    @NotNull(message = "是否启用不能为空")
    @ApiModelProperty(value = "是否启用")
    private Boolean ifEnable;
}
