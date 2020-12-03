package com.yanhuada.client.model.systemmessage.rsp;

import com.alibaba.fastjson.annotation.JSONField;
import com.yanhuada.common.model.IdLongToStrSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author yanhuada
 * CREATE ON 2020/8/10 17:32
 */
@Data
@ApiModel(value = "系统信息分页参数")
public class SystemMessagePagerRsp {

    @JSONField(serializeUsing = IdLongToStrSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value="系统信息标题")
    private String systemMessageTitle;
    @ApiModelProperty(value="系统信息内容")
    private String systemMessageContent;
    @ApiModelProperty(value="系统信息跳转链接")
    private String systemMessageUrl;
    @ApiModelProperty(value="系统信息url文本解释")
    private String systemMessageUrlText;
    @JSONField(format = "yyyy/MM/dd HH:mm:ss")
    @ApiModelProperty(value="时间")
    private LocalDateTime createdAt;
}
