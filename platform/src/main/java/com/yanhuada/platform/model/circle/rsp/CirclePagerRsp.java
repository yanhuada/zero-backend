package com.yanhuada.platform.model.circle.rsp;

import com.alibaba.fastjson.annotation.JSONField;
import com.yanhuada.common.model.IdLongToStrSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author yanhuada
 * CREATE ON 2020/8/12 18:12
 */
@Data
@ApiModel(value = "圈子分页参数")
public class CirclePagerRsp {
    @JSONField(serializeUsing = IdLongToStrSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value = "圈子名称")
    private String name;
    @ApiModelProperty(value = "圈子图标")
    private String icon;
    @ApiModelProperty(value = "用户数量")
    private Integer userNum;
    @ApiModelProperty(value = "是否启用")
    private Boolean ifEnable;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createdAt;
}
