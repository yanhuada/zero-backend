package com.yanhuada.client.model.weekly.rsp;

import com.alibaba.fastjson.annotation.JSONField;
import com.yanhuada.common.model.IdLongToStrSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author yanhuada
 * CREATE ON 2020/8/10 17:15
 */
@Data
@ApiModel(value = "周刊分页参数")
public class WeeklyPagerRsp{
    @JSONField(serializeUsing = IdLongToStrSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;
    @JSONField(serializeUsing = IdLongToStrSerializer.class)
    @ApiModelProperty(value="作者ID 即用户ID")
    private Long authorId;
    @ApiModelProperty(value="作者名称 即用户名称")
    private String authorName;
    @ApiModelProperty(value="封面")
    private String cover;
    @ApiModelProperty(value="标题")
    private String title;
    @JSONField(format = "yyyy/MM/dd HH:mm:ss")
    @ApiModelProperty(value="发布时间")
    private LocalDateTime publishTime;
}
