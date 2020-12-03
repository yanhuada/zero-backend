package com.yanhuada.client.model.user.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author yanhuada
 * CREATE ON 2020/8/27 17:29
 */
@Data
@ApiModel(value = "用户昵称修改参数")
public class UserNicknameUpdateReq {

    @NotBlank(message = "昵称不能为空")
    @ApiModelProperty(value = "昵称")
    private String nickname;
}
