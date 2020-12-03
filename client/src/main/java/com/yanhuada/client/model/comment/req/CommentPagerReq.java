package com.yanhuada.client.model.comment.req;

import com.yanhuada.common.model.PagerDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * @author yanhuada
 * CREATE ON 2020/8/28 18:16
 */
@Setter
@Getter
@ApiModel(value = "评论分页")
public class CommentPagerReq extends PagerDto {

    @NotNull(message = "id不能为空")
    @ApiModelProperty(value = "实体id")
    private Long entityId;
}
