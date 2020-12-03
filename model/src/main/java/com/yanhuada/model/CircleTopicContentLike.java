package com.yanhuada.model;

import com.yanhuada.common.model.BaseModelWithId;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class CircleTopicContentLike extends BaseModelWithId implements Serializable {
    @ApiModelProperty(value="用户ID")
    private Long userId;

    @ApiModelProperty(value="圈子专题内容ID")
    private Long circleTopicContentId;

    private static final long serialVersionUID = 1L;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCircleTopicContentId() {
        return circleTopicContentId;
    }

    public void setCircleTopicContentId(Long circleTopicContentId) {
        this.circleTopicContentId = circleTopicContentId;
    }
}