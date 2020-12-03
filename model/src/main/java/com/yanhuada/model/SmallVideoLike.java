package com.yanhuada.model;

import com.yanhuada.common.model.BaseModelWithId;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class SmallVideoLike extends BaseModelWithId implements Serializable {
    @ApiModelProperty(value="小视频ID")
    private Long smallVideoId;

    @ApiModelProperty(value="用户ID")
    private Long userId;

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
}