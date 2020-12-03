package com.yanhuada.platform.model.user.rsp;

import com.alibaba.fastjson.annotation.JSONField;
import com.yanhuada.common.model.IdLongToStrSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author yanhuada
 * CREATE ON 2020/8/12 15:35
 */
@Data
@ApiModel(value = "用户详情参数")
public class UserDetailRsp {
    @JSONField(serializeUsing = IdLongToStrSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value="昵称")
    private String nickname;
    @ApiModelProperty(value="用户头像")
    private String avatar;
    @ApiModelProperty(value = "身份")
    private String identity;
    @ApiModelProperty(value="是否启用")
    private Boolean ifEnable;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "注册时间")
    private LocalDateTime createdAt;



}
