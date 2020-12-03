package com.yanhuada.model;

import com.yanhuada.common.model.BaseModelWithId;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class ArtSpeakRecord extends BaseModelWithId implements Serializable {
    @ApiModelProperty(value="用户ID")
    private Long userId;

    @ApiModelProperty(value="说话的艺术ID")
    private Long artSpeakId;

    @ApiModelProperty(value="阅读次数")
    private Integer readNum;

    @ApiModelProperty(value="态度 0：不知道 1：喜欢 2：不喜欢")
    private Integer attitude;

    private static final long serialVersionUID = 1L;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getArtSpeakId() {
        return artSpeakId;
    }

    public void setArtSpeakId(Long artSpeakId) {
        this.artSpeakId = artSpeakId;
    }

    public Integer getReadNum() {
        return readNum;
    }

    public void setReadNum(Integer readNum) {
        this.readNum = readNum;
    }

    public Integer getAttitude() {
        return attitude;
    }

    public void setAttitude(Integer attitude) {
        this.attitude = attitude;
    }
}