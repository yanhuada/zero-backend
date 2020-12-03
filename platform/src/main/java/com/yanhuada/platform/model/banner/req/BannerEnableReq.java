package com.yanhuada.platform.model.banner.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author yanhuada
 * CREATE ON 2020/8/18 11:16
 */
@Data
@ApiModel(value = "设置是否为空参数")
public class BannerEnableReq {
    @NotNull(message = "id不能为空")
    public Long id;
    @NotNull(message = "是否为空不能为空")
    @ApiModelProperty(value = "是否为空")
    private Boolean ifEnable;
}
