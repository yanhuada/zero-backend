package com.yanhuada.platform.model.artspeak.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author yanhuada
 * CREATE ON 2020/8/17 14:04
 */
@Data
@ApiModel(value = "句子类型顺序更新参数")
public class ArtSpeakTypeSortUpdateReq {
    @NotNull(message = "id不能为空")
    public Long id;
    @NotNull(message = "顺序不能为空")
    @ApiModelProperty(value = "顺序")
    private Integer sort;
}
