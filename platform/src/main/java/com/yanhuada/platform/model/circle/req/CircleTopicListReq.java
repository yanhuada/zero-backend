package com.yanhuada.platform.model.circle.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author yanhuada
 * CREATE ON 2020/8/14 23:06
 */
@Setter
@Getter
@ApiModel(value = "圈子专题列表")
public class CircleTopicListReq {
    @ApiModelProperty(value = "circleId")
    private Long circleId;
    @ApiModelProperty(value = "圈子专题名称")
    private String name;
    @ApiModelProperty(value = "发布状态 0：未发布 1：已发布 2：已下架")
    private Integer publishStatus;
}
