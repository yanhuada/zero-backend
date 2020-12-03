package com.yanhuada.platform.model.circle.rsp;

import com.alibaba.fastjson.annotation.JSONField;
import com.yanhuada.common.model.IdLongToStrSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author yanhuada
 * CREATE ON 2020/8/15 2:21
 */
@Data
@ApiModel(value = "圈子专题内容分页参数")
public class CircleTopicContentPagerRsp {
    @JSONField(serializeUsing = IdLongToStrSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value="作者")
    private String author;
    @ApiModelProperty(value="专题标题")
    private String title;
    @ApiModelProperty(value="发布状态 0：未发布 1：已发布 2：已下架")
    private Integer publishStatus;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value="发布时间")
    private LocalDateTime publishTime;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createdAt;
    @JSONField(serializeUsing = IdLongToStrSerializer.class)
    @ApiModelProperty(value = "圈子ID")
    private Long circleId;
    @ApiModelProperty(value = "圈子名称")
    private String circleName;
    @JSONField(serializeUsing = IdLongToStrSerializer.class)
    @ApiModelProperty(value = "圈子专题id")
    private Long circleTopicId;
    @ApiModelProperty(value="圈子专题名称")
    private String circleTopicName;
}
