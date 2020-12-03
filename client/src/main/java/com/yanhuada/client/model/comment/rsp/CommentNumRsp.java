package com.yanhuada.client.model.comment.rsp;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author yanhuada
 * CREATE ON 2020/9/8 16:51
 */
@Data
@ApiModel(value = "数量")
public class CommentNumRsp {
    private Integer commentNum;
    private Integer likeNum;
}
