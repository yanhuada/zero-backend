package com.yanhuada.platform.model.user.req;

import com.yanhuada.common.model.PagerDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author yanhuada
 * CREATE ON 2020/8/11 14:49
 */
@Setter
@Getter
@ApiModel(value = "用户分页请求参数")
public class UserPagerReq extends PagerDto {

    @ApiModelProperty(value="昵称")
    private String nickname;
    @ApiModelProperty(value="手机号")
    private String phone;
    @ApiModelProperty(value = "身份 0: 不限 1：普通身份 2：作者 3：客服")
    private Integer identity = 0;
    @ApiModelProperty(value="是否启用")
    private Boolean ifEnable;
}
