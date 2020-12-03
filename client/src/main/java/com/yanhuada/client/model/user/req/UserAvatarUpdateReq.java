package com.yanhuada.client.model.user.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author yanhuada
 * CREATE ON 2020/8/27 17:28
 */
@Data
@ApiModel(value = "用户头像参数")
public class UserAvatarUpdateReq {

    @NotBlank(message = "用户头像不能为空")
    @ApiModelProperty(value = "用户头像")
    private String avatar;
}
