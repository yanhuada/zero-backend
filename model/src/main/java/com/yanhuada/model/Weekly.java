package com.yanhuada.model;

import com.yanhuada.common.model.BaseModelWithId;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDateTime;

public class Weekly extends BaseModelWithId implements Serializable {
    @ApiModelProperty(value="作者ID 即用户ID")
    private Long authorId;

    @ApiModelProperty(value="作者名称 即用户名称")
    private String authorName;

    @ApiModelProperty(value="作者头像 即用户头像")
    private String authorAvatar;

    @ApiModelProperty(value="封面")
    private String cover;

    @ApiModelProperty(value="标题")
    private String title;

    @ApiModelProperty(value="发布状态 0：未发布 1：已发布 2：已下架")
    private Integer publishStatus;

    @ApiModelProperty(value="发布时间")
    private LocalDateTime publishTime;

    @ApiModelProperty(value="下架时间")
    private LocalDateTime offTime;

    @ApiModelProperty(value="内容")
    private String content;

    private static final long serialVersionUID = 1L;

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName == null ? null : authorName.trim();
    }

    public String getAuthorAvatar() {
        return authorAvatar;
    }

    public void setAuthorAvatar(String authorAvatar) {
        this.authorAvatar = authorAvatar == null ? null : authorAvatar.trim();
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover == null ? null : cover.trim();
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

    public LocalDateTime getOffTime() {
        return offTime;
    }

    public void setOffTime(LocalDateTime offTime) {
        this.offTime = offTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}