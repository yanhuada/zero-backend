package com.yanhuada.client.model.feedback.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author yanhuada
 * CREATE ON 2020/8/10 17:05
 */
@Data
@ApiModel(value = "意见反馈新增参数")
public class FeedbackAddReq {

    @NotBlank(message = "反馈内容不能为空")
    @ApiModelProperty(value = "内容")
    private String content;
}
