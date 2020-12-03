package com.yanhuada.platform.model.weekly.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author yanhuada
 * CREATE ON 2020/8/13 17:49
 */
@Data
@ApiModel(value = "周刊新增参数")
public class WeeklyAddReq {
    @ApiModelProperty(value="作者ID 即用户ID")
    private Long authorId;
    @ApiModelProperty(value="封面")
    private String cover;
    @ApiModelProperty(value="标题")
    private String title;
    @ApiModelProperty(value="内容")
    private String content;
}
