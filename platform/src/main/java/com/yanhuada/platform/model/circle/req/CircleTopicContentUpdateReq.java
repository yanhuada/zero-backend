package com.yanhuada.platform.model.circle.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * @author yanhuada
 * CREATE ON 2020/8/15 2:16
 */
@Setter
@Getter
@ApiModel(value = "圈子专题内容编辑参数")
public class CircleTopicContentUpdateReq extends CircleTopicContentAddReq {
    @NotNull(message = "ID不能为空")
    @ApiModelProperty(value = "ID")
    private Long id;
}
