package com.yanhuada.platform.model.artspeak.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author yanhuada
 * CREATE ON 2020/8/17 14:07
 */
@Data
@ApiModel(value = "句子类型列表请求参数")
public class ArtSpeakTypeListReq {
    @ApiModelProperty(value = "说话的艺术分类名称")
    private String name;
    @ApiModelProperty(value = "是否启用")
    private Boolean ifEnable;
}
