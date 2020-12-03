package com.yanhuada.platform.model.banner.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author yanhuada
 * CREATE ON 2020/8/18 11:13
 */
@Data
@ApiModel(value = "banner顺序参数")
public class BannerSortUpdateReq {
    @NotNull(message = "id不能为空")
    public Long id;
    @NotNull(message = "顺序不能为空")
    @ApiModelProperty(value = "顺序")
    private Integer sort;
}
