package com.yanhuada.platform.model.weekly.rsp;

import com.alibaba.fastjson.annotation.JSONField;
import com.yanhuada.common.model.IdLongToStrSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author yanhuada
 * CREATE ON 2020/8/13 18:01
 */
@Data
@ApiModel(value = "周刊详情")
public class WeeklyDetailRsp {
    @JSONField(serializeUsing = IdLongToStrSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value="封面")
    private String cover;
    @ApiModelProperty(value="标题")
    private String title;
    @ApiModelProperty(value="发布状态 0：未发布 1：已发布 2：已下架")
    private Integer publishStatus;
    @ApiModelProperty(value="发布时间")
    private LocalDateTime publishTime;
    @ApiModelProperty(value="下架时间")
    private LocalDateTime offTime;
    @ApiModelProperty(value="内容")
    private String content;
    @ApiModelProperty(value="作者ID 即用户ID")
    private Long authorId;
    @ApiModelProperty(value="作者名称 即用户名称")
    private String authorName;
    @ApiModelProperty(value="作者头像 即用户头像")
    private String authorAvatar;
}
