package com.yanhuada.platform.model.circle.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * @author yanhuada
 * CREATE ON 2020/8/22 22:37
 */
@Setter
@Getter
@ApiModel(value = "圈子资源更新参数")
public class CircleResourceUpdateReq extends CircleResourceAddReq {
    @NotNull(message = "ID不能为空")
    @ApiModelProperty(value = "ID")
    private Long id;
}
