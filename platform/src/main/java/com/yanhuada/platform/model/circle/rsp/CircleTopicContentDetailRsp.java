package com.yanhuada.platform.model.circle.rsp;

import com.alibaba.fastjson.annotation.JSONField;
import com.yanhuada.common.model.IdLongToStrSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author yanhuada
 * CREATE ON 2020/8/15 11:32
 */
@Setter
@Getter
@ApiModel(value = "圈子专题内容详情参数")
public class CircleTopicContentDetailRsp extends CircleTopicContentPagerRsp{
    @ApiModelProperty(value="内容")
    private String content;
}
