package com.yanhuada.platform.model.user.rsp;

import com.alibaba.fastjson.annotation.JSONField;
import com.yanhuada.common.model.IdLongToStrSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author yanhuada
 * CREATE ON 2020/8/14 16:25
 */
@Data
@ApiModel(value = "作者参数")
public class UserAuthorRsp {
    @JSONField(serializeUsing = IdLongToStrSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value="用户昵称昵称")
    private String userNickname;
    @ApiModelProperty(value="用户头像")
    private String userAvatar;
}
