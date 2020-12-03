package com.yanhuada.platform.model.circle.rsp;

import com.alibaba.fastjson.annotation.JSONField;
import com.yanhuada.common.model.IdLongToStrSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author yanhuada
 * CREATE ON 2020/8/22 22:50
 */
@Data
@ApiModel(value = "圈子资源详情参数")
public class CircleResourceDetailRsp {
    @JSONField(serializeUsing = IdLongToStrSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;
    @JSONField(serializeUsing = IdLongToStrSerializer.class)
    @ApiModelProperty(value="圈子ID")
    private Long circleId;
    @ApiModelProperty(value = "圈子名称")
    private String circleName;
    @ApiModelProperty(value="资源标题")
    private String title;
    @ApiModelProperty(value="是否启用")
    private Boolean ifEnable;
    @ApiModelProperty(value="资源内容")
    private String content;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createdAt;
}
