package com.yanhuada.model;

import com.yanhuada.common.model.BaseModelWithId;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class CommentLike extends BaseModelWithId implements Serializable {
    @ApiModelProperty(value="用户ID")
    private Long userId;

    @ApiModelProperty(value="实体ID")
    private Long entityId;

    @ApiModelProperty(value="评论类型 0：专题评论 1：周刊评论 2：视频评论")
    private Integer type;

    @ApiModelProperty(value="是否是子评论")
    private Boolean ifSub;

    private static final long serialVersionUID = 1L;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Boolean getIfSub() {
        return ifSub;
    }

    public void setIfSub(Boolean ifSub) {
        this.ifSub = ifSub;
    }
}