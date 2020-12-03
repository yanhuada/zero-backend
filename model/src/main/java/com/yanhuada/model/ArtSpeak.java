package com.yanhuada.model;

import com.yanhuada.common.model.BaseModelWithId;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class ArtSpeak extends BaseModelWithId implements Serializable {
    @ApiModelProperty(value="说话的艺术分类ID")
    private Long artSpeakTypeId;

    @ApiModelProperty(value="说话的艺术分类名称")
    private String artSpeakTypeName;

    @ApiModelProperty(value="内容")
    private String content;

    @ApiModelProperty(value="点赞数量")
    private Integer likeNum;

    @ApiModelProperty(value="不喜欢数量")
    private Integer dislikeNum;

    @ApiModelProperty(value="是否启用")
    private Boolean ifEnable;

    private static final long serialVersionUID = 1L;

    public Long getArtSpeakTypeId() {
        return artSpeakTypeId;
    }

    public void setArtSpeakTypeId(Long artSpeakTypeId) {
        this.artSpeakTypeId = artSpeakTypeId;
    }

    public String getArtSpeakTypeName() {
        return artSpeakTypeName;
    }

    public void setArtSpeakTypeName(String artSpeakTypeName) {
        this.artSpeakTypeName = artSpeakTypeName == null ? null : artSpeakTypeName.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    public Integer getDislikeNum() {
        return dislikeNum;
    }

    public void setDislikeNum(Integer dislikeNum) {
        this.dislikeNum = dislikeNum;
    }

    public Boolean getIfEnable() {
        return ifEnable;
    }

    public void setIfEnable(Boolean ifEnable) {
        this.ifEnable = ifEnable;
    }
}