package com.yanhuada.model;

import com.yanhuada.common.model.BaseModelWithId;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class Notice extends BaseModelWithId implements Serializable {
    @ApiModelProperty(value="公告内容")
    private String content;

    @ApiModelProperty(value="是否显示 0：隐藏 1：显示 只能有一个是显示")
    private Boolean ifShow;

    private static final long serialVersionUID = 1L;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Boolean getIfShow() {
        return ifShow;
    }

    public void setIfShow(Boolean ifShow) {
        this.ifShow = ifShow;
    }
}