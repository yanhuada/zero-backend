package com.yanhuada.client.model.comment.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author yanhuada
 * CREATE ON 2020/8/28 18:08
 */
@Data
@ApiModel(value = "评论新增参数")
public class CommentAddReq {

    @NotNull(message = "id不能为空")
    @ApiModelProperty(value = "实体id")
    private Long entityId;

    @NotBlank(message = "评论内容不能为空")
    @ApiModelProperty(value = "评论内容")
    private String content;
}
