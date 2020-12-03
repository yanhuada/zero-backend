package com.yanhuada.platform.model.commonproblem.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author yanhuada
 * CREATE ON 2020/8/27 17:57
 */
@Data
@ApiModel(value = "常见问题新增参数")
public class CommonProblemAddReq {
    @NotBlank(message = "标题不能为空")
    @ApiModelProperty(value = "标题")
    private String title;
    @NotNull(message = "是否启用不能为空")
    @ApiModelProperty(value = "是否启用")
    private Boolean ifEnable;
    @NotBlank(message = "内容不能为空")
    @ApiModelProperty(value = "内容")
    private String content;
}
