package com.yanhuada.client.model.user.rsp;

import com.alibaba.fastjson.annotation.JSONField;
import com.yanhuada.common.model.IdLongToStrSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author yanhuada
 * CREATE ON 2020/8/8 14:37
 */
@Data
@ApiModel(value = "用户登陆返回参数")
public class UserLoginRsp {

    @JSONField(serializeUsing = IdLongToStrSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value="昵称")
    private String nickname;

    @ApiModelProperty(value="用户头像")
    private String avatar;

    @ApiModelProperty(value="电子邮箱")
    private String email;

    @ApiModelProperty(value="手机号")
    private String phone;

    @ApiModelProperty(value="地址")
    private String location;
}
