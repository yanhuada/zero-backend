package com.yanhuada.client.model.circle.req;

import com.yanhuada.common.model.PagerDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * @author yanhuada
 * CREATE ON 2020/8/22 22:02
 */
@Setter
@Getter
@ApiModel(value = "圈子用户分页")
public class CircleUserPagerReq extends PagerDto {

    @NotNull(message = "圈子ID不能为空")
    @ApiModelProperty(value = "圈子ID")
    private Long circleId;
}
