package com.yanhuada.client.model.circle.req;

import com.yanhuada.common.model.PagerDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * @author yanhuada
 * CREATE ON 2020/8/21 17:30
 */
@Setter
@Getter
@ApiModel(value = "圈子内容分页请求参数")
public class CircleTopicContentPagerReq extends PagerDto {
    @NotNull(message = "圈子专题ID不能为空")
    @ApiModelProperty(value = "圈子专题ID")
    private Long circleTopicId;
}
