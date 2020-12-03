package com.yanhuada.model;

import com.yanhuada.common.model.BaseModelWithId;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class Banner extends BaseModelWithId implements Serializable {
    @ApiModelProperty(value="标题")
    private String title;

    @ApiModelProperty(value="图片key值")
    private String imageKey;

    @ApiModelProperty(value="跳转链接")
    private String link;

    @ApiModelProperty(value="顺序")
    private Integer sort;

    @ApiModelProperty(value="是否启用")
    private Boolean ifEnable;

    private static final long serialVersionUID = 1L;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getImageKey() {
        return imageKey;
    }

    public void setImageKey(String imageKey) {
        this.imageKey = imageKey == null ? null : imageKey.trim();
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link == null ? null : link.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Boolean getIfEnable() {
        return ifEnable;
    }

    public void setIfEnable(Boolean ifEnable) {
        this.ifEnable = ifEnable;
    }
}