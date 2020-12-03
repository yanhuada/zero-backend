package com.yanhuada.common.util.webchat.miniapp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author yanhuada
 * CREATE ON 2020/3/22 22:54
 */
@Data
@ApiModel(value = "小程序登陆请求参数")
public class MiniappInfoReq {
    @NotBlank(message = "code不能为空")
    private String code;
    @NotBlank(message = "iv不能为空")
    private String iv;
    @NotBlank(message = "encryptedData不能为空")
    private String encryptedData;
    @NotBlank(message = "signature不能为空")
    private String signature;
    @NotBlank(message = "rawData不能为空")
    private String rawData;
}
