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
@ApiModel(value = "句子新增参数")
public class ArtSpeakAddReq {
    @NotNull(message = "分类ID不能为空")
    @ApiModelProperty(value = "说话的艺术分类ID")
    private Long artSpeakTypeId;
    @NotBlank(message = "内容不能为空")
    @ApiModelProperty(value = "内容")
    private String content;
    @NotNull(message = "是否启用不能为空")
    @ApiModelProperty(value = "是否启用")
    private Boolean ifEnable;
}
