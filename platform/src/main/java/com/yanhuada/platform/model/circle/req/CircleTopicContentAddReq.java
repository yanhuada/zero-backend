package com.yanhuada.platform.model.circle.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author yanhuada
 * CREATE ON 2020/8/15 2:12
 */
@Setter
@Getter
@ApiModel(value = "圈子专题内容新增参数")
public class CircleTopicContentAddReq {
    @NotNull(message = "圈子专题ID不能为空")
    @ApiModelProperty(value = "圈子专题ID")
    private Long circleTopicId;
    @NotBlank(message = "作者不能为空")
    @ApiModelProperty(value = "作者")
    private String author;
    @NotBlank(message = "标题不能为空")
    @ApiModelProperty(value = "专题标题")
    private String title;
    @NotBlank(message = "内容不能为空")
    @ApiModelProperty(value = "专题内容")
    private String content;
}
