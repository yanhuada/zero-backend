package com.yanhuada.platform.model.admin.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author yanhuada
 * CREATE ON 2020/8/10 18:33
 */
@Data
@ApiModel(value = "管理员登陆参数")
public class AdminLoginReq {

    @NotBlank(message = "账号不能为空")
    @ApiModelProperty(value = "账号")
    private String name;

    @NotBlank(message = "密码不能为空")
    @ApiModelProperty(value = "密码")
    private String password;
}
