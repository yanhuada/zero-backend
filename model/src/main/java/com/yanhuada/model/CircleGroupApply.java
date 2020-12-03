package com.yanhuada.model;

import com.yanhuada.common.model.BaseModelWithId;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class CircleGroupApply extends BaseModelWithId implements Serializable {
    @ApiModelProperty(value="圈子ID")
    private Long circleId;

    @ApiModelProperty(value="用户ID")
    private Long userId;

    @ApiModelProperty(value="昵称")
    private String userNickname;

    @ApiModelProperty(value="用户头像")
    private String userAvatar;

    @ApiModelProperty(value="申请状态 0：申请中 1：已通过 2：未通过")
    private Integer status;

    private static final long serialVersionUID = 1L;

    public Long getCircleId() {
        return circleId;
    }

    public void setCircleId(Long circleId) {
        this.circleId = circleId;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}