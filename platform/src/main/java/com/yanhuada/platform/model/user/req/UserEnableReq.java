package com.yanhuada.platform.model.user.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author yanhuada
 * CREATE ON 2020/8/12 15:49
 */
@Data
@ApiModel(value = "用户启用参数")
public class UserEnableReq {
    @ApiModelProperty(value = "用户ID")
    private Long id;
    @ApiModelProperty(value = "是否启用")
    private Boolean enable;
}
