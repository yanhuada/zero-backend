package com.yanhuada.platform.model.circle.rsp;

import com.alibaba.fastjson.annotation.JSONField;
import com.yanhuada.common.model.IdLongToStrSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author yanhuada
 * CREATE ON 2020/8/14 22:52
 */
@Setter
@Getter
@ApiModel(value = "圈子专题列表")
public class CircleTopicListRsp {
    @JSONField(serializeUsing = IdLongToStrSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value="圈子专题名称")
    private String name;
    @JSONField(serializeUsing = IdLongToStrSerializer.class)
    @ApiModelProperty(value="圈子ID")
    private Long circleId;
    @ApiModelProperty(value = "圈子名称")
    private String circleName;
    @ApiModelProperty(value="专题顺序")
    private Integer sort;
    @ApiModelProperty(value="发布状态 0：未发布 1：已发布 2：已下架")
    private Integer publishStatus;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value="发布时间")
    private LocalDateTime publishTime;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createdAt;
}
