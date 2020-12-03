package com.yanhuada.client.model.circle.rsp;

import com.alibaba.fastjson.annotation.JSONField;
import com.yanhuada.common.model.IdLongToStrSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author yanhuada
 * CREATE ON 2020/8/10 17:22
 */
@Data
@ApiModel(value = "圈子列表参数")
public class CircleListRsp {
    @JSONField(serializeUsing = IdLongToStrSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value="圈子名称")
    private String name;
    @ApiModelProperty(value="圈子图标")
    private String icon;
    @ApiModelProperty(value="圈子封面")
    private String cover;
    @ApiModelProperty(value="用户数量")
    private Integer userNum;
}
