package com.yanhuada.model;

import com.yanhuada.common.model.BaseModelWithId;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class CircleResource extends BaseModelWithId implements Serializable {
    @ApiModelProperty(value="圈子ID")
    private Long circleId;

    @ApiModelProperty(value="资源标题")
    private String title;

    @ApiModelProperty(value="是否启用")
    private Boolean ifEnable;

    @ApiModelProperty(value="资源内容")
    private String content;

    private static final long serialVersionUID = 1L;

    public Long getCircleId() {
        return circleId;
    }

    public void setCircleId(Long circleId) {
        this.circleId = circleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Boolean getIfEnable() {
        return ifEnable;
    }

    public void setIfEnable(Boolean ifEnable) {
        this.ifEnable = ifEnable;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}