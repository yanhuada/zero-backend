package com.yanhuada.client.model.circle.rsp;

import com.alibaba.fastjson.annotation.JSONField;
import com.yanhuada.common.model.IdLongToStrSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author yanhuada
 * CREATE ON 2020/8/22 22:06
 */
@Data
@ApiModel(value = "圈子资源详情")
public class CircleResourceDetailRsp {
    @JSONField(serializeUsing = IdLongToStrSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value="资源标题")
    private String title;
    @ApiModelProperty(value="资源内容")
    private String content;
}
