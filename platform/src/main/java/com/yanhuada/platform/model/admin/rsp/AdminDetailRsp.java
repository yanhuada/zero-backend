package com.yanhuada.platform.model.admin.rsp;

import com.alibaba.fastjson.annotation.JSONField;
import com.yanhuada.common.model.IdLongToStrSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author yanhuada
 * CREATE ON 2020/8/10 18:41
 */
@Data
@ApiModel(value = "管理员详情参数")
public class AdminDetailRsp {

    @JSONField(serializeUsing = IdLongToStrSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value="名称")
    private String name;

    @ApiModelProperty(value="邮箱")
    private String email;

    @ApiModelProperty(value="手机号")
    private String phone;

    @ApiModelProperty(value="是否超级管理员 0：普通管理员 1：超级管理员")
    private Boolean ifSuper;
}
