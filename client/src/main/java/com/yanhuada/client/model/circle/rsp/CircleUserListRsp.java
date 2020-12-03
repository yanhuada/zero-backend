package com.yanhuada.client.model.circle.rsp;

import com.alibaba.fastjson.annotation.JSONField;
import com.yanhuada.common.model.IdLongToStrSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author yanhuada
 * CREATE ON 2020/8/10 17:24
 */
@Data
@ApiModel(value = "圈子用户列表参数")
public class CircleUserListRsp  {
    @JSONField(serializeUsing = IdLongToStrSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value="昵称")
    private String nickname;
    @ApiModelProperty(value="用户头像")
    private String avatar;
}
