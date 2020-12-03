package com.yanhuada.platform.model.circle.req;

import com.yanhuada.common.model.PagerDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author yanhuada
 * CREATE ON 2020/8/15 2:19
 */
@Setter
@Getter
@ApiModel(value = "圈子专题内容分页参数")
public class CircleTopicContentPagerReq extends PagerDto {
    @ApiModelProperty(value="圈子ID")
    private Long circleId;
    @ApiModelProperty(value="圈子专题ID")
    private Long circleTopicId;
    @ApiModelProperty(value="作者")
    private String author;
    @ApiModelProperty(value="专题标题")
    private String title;
    @ApiModelProperty(value="发布状态 0：未发布 1：已发布 2：已下架")
    private Integer publishStatus;
}
