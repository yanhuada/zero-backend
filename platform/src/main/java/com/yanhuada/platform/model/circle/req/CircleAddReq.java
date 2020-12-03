package com.yanhuada.platform.model.circle.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author yanhuada
 * CREATE ON 2020/8/12 18:05
 */
@Setter
@Getter
@ApiModel(value = "圈子新增参数")
public class CircleAddReq {

    @ApiModelProperty(value="圈子名称")
    private String name;
    @ApiModelProperty(value="圈子图标")
    private String icon;
    @ApiModelProperty(value="圈子封面")
    private String cover;
    @ApiModelProperty(value="圈子简介")
    private String introduce;
}
