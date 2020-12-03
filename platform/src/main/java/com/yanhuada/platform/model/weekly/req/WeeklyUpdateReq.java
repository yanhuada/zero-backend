package com.yanhuada.platform.model.weekly.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author yanhuada
 * CREATE ON 2020/8/13 17:53
 */
@Setter
@Getter
@ApiModel(value = "周刊编辑参数")
public class WeeklyUpdateReq extends WeeklyAddReq {
    @ApiModelProperty(value = "ID")
    private Long id;
}
