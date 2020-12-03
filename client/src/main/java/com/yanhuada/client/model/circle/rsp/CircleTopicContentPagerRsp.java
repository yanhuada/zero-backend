package com.yanhuada.client.model.circle.rsp;

import com.alibaba.fastjson.annotation.JSONField;
import com.yanhuada.common.model.IdLongToStrSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author yanhuada
 * CREATE ON 2020/8/10 17:28
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
    @JSONField(format = "yyyy/MM/dd HH:mm:ss")
    @ApiModelProperty(value="发布时间")
    private LocalDateTime publishTime;
}
