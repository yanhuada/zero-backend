package com.yanhuada.platform.model.weekly.req;

import com.yanhuada.common.model.PagerDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author yanhuada
 * CREATE ON 2020/8/13 17:59
 */
@Setter
@Getter
@ApiModel(value = "周刊分页请求参数")
public class WeeklyPagerReq extends PagerDto {
    @ApiModelProperty(value="作者ID 即用户ID")
    private Long authorId;
    @ApiModelProperty(value="标题")
    private String title;
    @ApiModelProperty(value="发布状态 0：未发布 1：已发布 2：已下架")
    private Integer publishStatus;
}
