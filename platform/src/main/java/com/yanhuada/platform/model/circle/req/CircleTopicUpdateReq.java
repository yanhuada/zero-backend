package com.yanhuada.platform.model.circle.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * @author yanhuada
 * CREATE ON 2020/8/15 1:28
 */
@Setter
@Getter
public class CircleTopicUpdateReq extends CircleTopicAddReq {
    @NotNull(message = "ID不能为空")
    @ApiModelProperty(value = "ID")
    private Long id;
}
