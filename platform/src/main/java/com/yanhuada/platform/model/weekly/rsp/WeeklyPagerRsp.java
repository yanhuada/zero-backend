package com.yanhuada.platform.model.weekly.rsp;

import com.alibaba.fastjson.annotation.JSONField;
import com.yanhuada.common.model.IdLongToStrSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author yanhuada
 * CREATE ON 2020/8/13 17:58
 */
@Data
@ApiModel(value = "周刊分页参数")
public class WeeklyPagerRsp {
    @JSONField(serializeUsing = IdLongToStrSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value="作者名称 即用户名称")
    private String authorName;
    @ApiModelProperty(value="封面")
    private String cover;
    @ApiModelProperty(value="标题")
    private String title;
    @ApiModelProperty(value="发布状态")
    private Integer publishStatus;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value="发布时间")
    private LocalDateTime publishTime;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value="下架时间")
    private LocalDateTime offTime;
}
