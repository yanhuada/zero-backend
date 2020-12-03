package com.yanhuada.model;

import com.yanhuada.common.model.BaseModelWithId;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class ArtSpeakType extends BaseModelWithId implements Serializable {
    @ApiModelProperty(value="说话的艺术分类名称")
    private String name;

    @ApiModelProperty(value="顺序")
    private Integer sort;

    @ApiModelProperty(value="是否启用")
    private Boolean ifEnable;

    private static final long serialVersionUID = 1L;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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