package com.yanhuada.client.model.comment.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author yanhuada
 * CREATE ON 2020/9/7 12:37
 */
@Data
@ApiModel(value = "评论点赞参数")
public class CommentLikeReq {
    @NotNull(message = "id不能为空")
    @ApiModelProperty(value = "实体id")
    private Long entityId;
    @NotNull(message = "是否点赞不能为空")
    @ApiModelProperty(value = "是否点赞")
    private Boolean ifLike;
}
