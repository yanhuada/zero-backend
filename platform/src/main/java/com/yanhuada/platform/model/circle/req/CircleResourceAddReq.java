package com.yanhuada.platform.model.circle.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author yanhuada
 * CREATE ON 2020/8/22 22:36
 */
@Data
@ApiModel(value = "圈子资源新增参数")
public class CircleResourceAddReq {
    @NotNull(message = "圈子id不能为空")
    @ApiModelProperty(value = "圈子ID")
    private Long circleId;
    @NotBlank(message = "资源标题不能为空")
    @ApiModelProperty(value = "资源标题")
    private String title;
    @ApiModelProperty(value = "是否启用")
    private Boolean ifEnable = false;
    @NotBlank(message = "资源内容不能为空")
    @ApiModelProperty(value = "资源内容")
    private String content;
}
