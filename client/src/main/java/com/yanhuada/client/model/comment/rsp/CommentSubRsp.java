package com.yanhuada.client.model.comment.rsp;

import com.alibaba.fastjson.annotation.JSONField;
import com.yanhuada.common.model.IdLongToStrSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author yanhuada
 * CREATE ON 2020/9/7 11:01
 */
@Data
@ApiModel(value = "子评论详情")
public class CommentSubRsp {
    @JSONField(serializeUsing = IdLongToStrSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;
    @JSONField(serializeUsing = IdLongToStrSerializer.class)
    @ApiModelProperty(value="用户ID")
    private Long userId;
    @ApiModelProperty(value="用户昵称")
    private String userNickname;
    @ApiModelProperty(value="用户头像")
    private String userAvatar;
    @ApiModelProperty(value="根用户ID")
    private Long rootUserId;
    @ApiModelProperty(value="根用户昵称")
    private String rootUserNickname;
    @ApiModelProperty(value="根用户头像")
    private String rootUserAvatar;
    @ApiModelProperty(value="评论内容")
    private String content;
    @ApiModelProperty(value="点赞数量")
    private Integer likeNum;
    @ApiModelProperty(value="是否删除 0：未删除 1：已删除")
    private Boolean ifDelete;
    @ApiModelProperty(value = "是否点赞")
    private Boolean ifLike;
    @JSONField(format = "yyyy/MM/dd HH:mm:ss")
    @ApiModelProperty(value="时间")
    private LocalDateTime createdAt;
}
