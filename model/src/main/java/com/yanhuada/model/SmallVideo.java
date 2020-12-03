package com.yanhuada.model;

import com.yanhuada.common.model.BaseModelWithId;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDateTime;

public class SmallVideo extends BaseModelWithId implements Serializable {
    @ApiModelProperty(value="视频key值")
    private String videoKey;

    @ApiModelProperty(value="视频标题")
    private String title;

    @ApiModelProperty(value="发布状态 0：未发布 1：已发布 2：已下架")
    private Integer publishStatus;

    @ApiModelProperty(value="发布时间")
    private LocalDateTime publishTime;

    @ApiModelProperty(value="点赞数量")
    private Integer likeNum;

    @ApiModelProperty(value="评论数量")
    private Integer commentNum;

    private static final long serialVersionUID = 1L;

    public String getVideoKey() {
        return videoKey;
    }

    public void setVideoKey(String videoKey) {
        this.videoKey = videoKey == null ? null : videoKey.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getPublishStatus() {
        return publishStatus;
    }

    public void setPublishStatus(Integer publishStatus) {
        this.publishStatus = publishStatus;
    }

    public LocalDateTime getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(LocalDateTime publishTime) {
        this.publishTime = publishTime;
    }

    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }
}