package com.yanhuada.platform.model.commonproblem.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * @author yanhuada
 * CREATE ON 2020/8/27 17:58
 */
@Setter
@Getter
@ApiModel(value = "常见问题更新参数")
public class CommonProblemUpdateReq extends CommonProblemAddReq {
    @NotNull(message = "ID不能为空")
    @ApiModelProperty(value = "ID")
    private Long id;
}
