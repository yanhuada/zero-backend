package com.yanhuada.platform.model.circle.req;

import com.yanhuada.common.model.PagerDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author yanhuada
 * CREATE ON 2020/8/12 18:13
 */
@Setter
@Getter
@ApiModel(value = "圈子分页参数")
public class CirclePagerReq extends PagerDto {

    @ApiModelProperty(value="圈子名称")
    private String name;
    @ApiModelProperty(value="是否启用")
    private Boolean ifEnable;
}
