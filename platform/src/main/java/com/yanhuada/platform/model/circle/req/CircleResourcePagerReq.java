package com.yanhuada.platform.model.circle.req;

import com.yanhuada.common.model.PagerDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author yanhuada
 * CREATE ON 2020/8/22 22:40
 */
@Setter
@Getter
@ApiModel(value = "圈子资源分页参数")
public class CircleResourcePagerReq extends PagerDto {
    @ApiModelProperty(value="圈子ID")
    private Long circleId;
    @ApiModelProperty(value="资源标题")
    private String title;
    @ApiModelProperty(value="是否启用")
    private Boolean ifEnable;
}
