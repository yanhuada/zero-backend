package com.yanhuada.client.model.comment.rsp;

import com.alibaba.fastjson.annotation.JSONField;
import com.yanhuada.common.model.IdLongToStrSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author yanhuada
 * CREATE ON 2020/8/28 18:08
 */

@Data
@ApiModel(value = "评论分页")
public class CommentPagerRsp {
    @JSONField(serializeUsing = IdLongToStrSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;
    @JSONField(serializeUsing = IdLongToStrSerializer.class)
    @ApiModelProperty(value = "实体ID")
    private Long entityId;
    @JSONField(serializeUsing = IdLongToStrSerializer.class)
    @ApiModelProperty(value = "用户ID")
    private Long userId;
    @ApiModelProperty(value = "用户昵称")
    private String userNickname;
    @ApiModelProperty(value = "用户头像")
    private String userAvatar;
    @ApiModelProperty(value = "评论内容")
    private String content;
    @ApiModelProperty(value = "点赞数量")
    private Integer likeNum;
    @ApiModelProperty(value = "回复数量")
    private Integer replyNum;
    @ApiModelProperty(value = "是否删除 0：未删除 1：已删除")
    private Boolean ifDelete;
    @ApiModelProperty(value = "是否点赞")
    private Boolean ifLike;
    @ApiModelProperty(value = "子评论数量")
    private Integer subReplyNum;
    @ApiModelProperty(value = "子评论列表")
    private List<CommentSubRsp> subRspList;
    @JSONField(format = "yyyy/MM/dd HH:mm:ss")
    @ApiModelProperty(value="时间")
    private LocalDateTime createdAt;
}
