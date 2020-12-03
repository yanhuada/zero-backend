package com.yanhuada.client.model.user.req;

import com.yanhuada.common.validator.Phone;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;

/**
 * @author yanhuada
 * CREATE ON 2020/8/9 23:05
 */
@Data
@ApiModel(value = "用户手机号登陆参数")
public class UserPhoneLoginReq {

    @Phone(message = "手机号格式错误")
    @ApiModelProperty(value = "手机号")
    private String phone;

//    @Max(value = 4, message = "验证码格式错误")
    @ApiModelProperty(value = "验证码")
    private String captcha;

}
