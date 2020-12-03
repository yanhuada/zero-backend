package com.yanhuada.platform.model.artspeak.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author yanhuada
 * CREATE ON 2020/8/17 13:58
 */
@Data
@ApiModel(value = "句子类型新增参数")
public class ArtSpeakTypeAddReq {
    @NotBlank(message = "名称不能为空")
    @ApiModelProperty(value = "说话的艺术分类名称")
    private String name;
    @ApiModelProperty(value = "顺序")
    private Integer sort = 0;
    @NotNull(message = "是否启用不能为空")
    @ApiModelProperty(value = "是否启用")
    private Boolean ifEnable;
}
