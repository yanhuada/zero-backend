package com.yanhuada.model;

import com.yanhuada.common.model.BaseModelWithId;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class Feedback extends BaseModelWithId implements Serializable {
    @ApiModelProperty(value="用户ID")
    private Long userId;

    @ApiModelProperty(value="昵称")
    private String userNickname;

    @ApiModelProperty(value="用户头像")
    private String userAvatar;

    @ApiModelProperty(value="内容")
    private String content;

    @ApiModelProperty(value="是否处理 0：未处理 1：已处理")
    private Boolean ifHandle;

    private static final long serialVersionUID = 1L;

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

    public Boolean getIfHandle() {
        return ifHandle;
    }

    public void setIfHandle(Boolean ifHandle) {
        this.ifHandle = ifHandle;
    }
}