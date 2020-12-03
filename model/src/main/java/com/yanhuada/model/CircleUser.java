package com.yanhuada.model;

import com.yanhuada.common.model.BaseModelWithId;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class CircleUser extends BaseModelWithId implements Serializable {
    @ApiModelProperty(value="圈子ID")
    private Long circleId;

    @ApiModelProperty(value="圈子名称")
    private String circleName;

    @ApiModelProperty(value="圈子图标")
    private String circleIcon;

    @ApiModelProperty(value="用户数量")
    private Integer circleUserNum;

    @ApiModelProperty(value="用户ID")
    private Long userId;

    @ApiModelProperty(value="昵称")
    private String userNickname;

    @ApiModelProperty(value="用户头像")
    private String userAvatar;

    @ApiModelProperty(value="申请加群状态 0：未申请 1：申请中 2：申请失败 3：已加群 4：已退群")
    private Integer applyGroupStatus;

    private static final long serialVersionUID = 1L;

    public Long getCircleId() {
        return circleId;
    }

    public void setCircleId(Long circleId) {
        this.circleId = circleId;
    }

    public String getCircleName() {
        return circleName;
    }

    public void setCircleName(String circleName) {
        this.circleName = circleName == null ? null : circleName.trim();
    }

    public String getCircleIcon() {
        return circleIcon;
    }

    public void setCircleIcon(String circleIcon) {
        this.circleIcon = circleIcon == null ? null : circleIcon.trim();
    }

    public Integer getCircleUserNum() {
        return circleUserNum;
    }

    public void setCircleUserNum(Integer circleUserNum) {
        this.circleUserNum = circleUserNum;
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

    public Integer getApplyGroupStatus() {
        return applyGroupStatus;
    }

    public void setApplyGroupStatus(Integer applyGroupStatus) {
        this.applyGroupStatus = applyGroupStatus;
    }
}