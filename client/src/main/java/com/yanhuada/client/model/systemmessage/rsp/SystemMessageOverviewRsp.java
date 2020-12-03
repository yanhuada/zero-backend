package com.yanhuada.client.model.systemmessage.rsp;

import com.alibaba.fastjson.annotation.JSONField;
import com.yanhuada.common.model.IdLongToStrSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author yanhuada
 * CREATE ON 2020/8/24 18:12
 */
@Data
@ApiModel(value = "系统信息概览")
public class SystemMessageOverviewRsp {

    @JSONField(serializeUsing = IdLongToStrSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value="系统信息标题")
    private String systemMessageTitle;
    @JSONField(format = "yyyy/MM/dd HH:mm:ss")
    @ApiModelProperty(value="时间")
    private LocalDateTime createdAt;
    @ApiModelProperty(value = "未读信息数量")
    private Integer count;

}
