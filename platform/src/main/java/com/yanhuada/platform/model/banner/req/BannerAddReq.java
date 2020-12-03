package com.yanhuada.platform.model.banner.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author yanhuada
 * CREATE ON 2020/8/18 10:34
 */
@Data
@ApiModel(value = "banner新增参数")
public class BannerAddReq {
    @ApiModelProperty(value = "标题")
    private String title;
    @NotBlank(message = "图片不能为空")
    @ApiModelProperty(value = "图片key值")
    private String imageKey;
    @ApiModelProperty(value = "跳转链接")
    private String link;
    @ApiModelProperty(value = "顺序")
    private Integer sort = 0;
    @NotNull(message = "是否启用不能为空")
    @ApiModelProperty(value = "是否启用")
    private Boolean ifEnable;
}
