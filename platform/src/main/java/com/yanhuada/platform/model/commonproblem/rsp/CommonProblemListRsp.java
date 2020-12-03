package com.yanhuada.platform.model.commonproblem.rsp;

import com.alibaba.fastjson.annotation.JSONField;
import com.yanhuada.common.model.IdLongToStrSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author yanhuada
 * CREATE ON 2020/8/27 18:00
 */
@Data
@ApiModel(value = "常见问题列表参数")
public class CommonProblemListRsp {
    @JSONField(serializeUsing = IdLongToStrSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value="标题")
    private String title;
    @ApiModelProperty(value="是否启用")
    private Boolean ifEnable;
    @ApiModelProperty(value="内容")
    private String content;
}
