package com.yanhuada.model;

import com.yanhuada.common.model.BaseModelWithId;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class SmallVideoComment extends BaseModelWithId implements Serializable {
    @ApiModelProperty(value="小视频ID")
    private Long smallVideoId;

    @ApiModelProperty(value="用户ID")
    private Long userId;

    @ApiModelProperty(value="用户昵称")
    private String userNickname;

    @ApiModelProperty(value="用户头像")
    private String userAvatar;

    @ApiModelProperty(value="评论内容")
    private String content;

    @ApiModelProperty(value="点赞数量")
    private Integer likeNum;

    @ApiModelProperty(value="回复数量")
    private Integer replyNum;

    @ApiModelProperty(value="是否删除 0：未删除 1：已删除")
    private Boolean ifDelete;

    private static final long serialVersionUID = 1L;

    public Long getSmallVideoId() {
        return smallVideoId;
    }

    public void setSmallVideoId(Long smallVideoId) {
        this.smallVideoId = smallVideoId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname == null ? null : userNickname.trim();
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar == null ? null : userAvatar.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    public Integer getReplyNum() {
        return replyNum;
    }

    public void setReplyNum(Integer replyNum) {
        this.replyNum = replyNum;
    }

    public Boolean getIfDelete() {
        return ifDelete;
    }

    public void setIfDelete(Boolean ifDelete) {
        this.ifDelete = ifDelete;
    }
}