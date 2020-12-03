package com.yanhuada.model;

import com.yanhuada.common.model.BaseModelWithId;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class SmallVideoSubComment extends BaseModelWithId implements Serializable {
    @ApiModelProperty(value="根评论ID")
    private Long smallVideoCommentId;

    @ApiModelProperty(value="根用户ID")
    private Long rootUserId;

    @ApiModelProperty(value="根用户昵称")
    private String rootUserNickname;

    @ApiModelProperty(value="根用户头像")
    private String rootUserAvatar;

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

    @ApiModelProperty(value="是否删除 0：未删除 1：已删除")
    private Boolean ifDelete;

    private static final long serialVersionUID = 1L;

    public Long getSmallVideoCommentId() {
        return smallVideoCommentId;
    }

    public void setSmallVideoCommentId(Long smallVideoCommentId) {
        this.smallVideoCommentId = smallVideoCommentId;
    }

    public Long getRootUserId() {
        return rootUserId;
    }

    public void setRootUserId(Long rootUserId) {
        this.rootUserId = rootUserId;
    }

    public String getRootUserNickname() {
        return rootUserNickname;
    }

    public void setRootUserNickname(String rootUserNickname) {
        this.rootUserNickname = rootUserNickname == null ? null : rootUserNickname.trim();
    }

    public String getRootUserAvatar() {
        return rootUserAvatar;
    }

    public void setRootUserAvatar(String rootUserAvatar) {
        this.rootUserAvatar = rootUserAvatar == null ? null : rootUserAvatar.trim();
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

    public Boolean getIfDelete() {
        return ifDelete;
    }

    public void setIfDelete(Boolean ifDelete) {
        this.ifDelete = ifDelete;
    }
}