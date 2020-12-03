package com.yanhuada.platform.model.circle.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author yanhuada
 * CREATE ON 2020/8/14 22:47
 */
@Setter
@Getter
@ApiModel(value = "圈子专题新增参数")
public class CircleTopicAddReq {

    @NotNull(message = "圈子ID不能为空")
    @ApiModelProperty(value = "圈子ID")
    private Long circleId;
    @NotBlank(message = "圈子专题名称不能为空")
    @ApiModelProperty(value = "圈子专题名称")
    private String name;
    @ApiModelProperty(value = "专题顺序")
    private Integer sort = 0;
}
