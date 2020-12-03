package com.yanhuada.platform.model.artspeak.rsp;

import com.alibaba.fastjson.annotation.JSONField;
import com.yanhuada.common.model.IdLongToStrSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author yanhuada
 * CREATE ON 2020/8/17 12:57
 */
@Data
@ApiModel(value = "说话的艺术类型参数列表")
public class ArtSpeakTypeListRsp {
    @JSONField(serializeUsing = IdLongToStrSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value="说话的艺术分类名称")
    private String name;
    @ApiModelProperty(value="顺序")
    private Integer sort;
    @ApiModelProperty(value="是否启用")
    private Boolean ifEnable;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createdAt;
}
