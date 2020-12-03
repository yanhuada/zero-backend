package com.yanhuada.model;

import com.yanhuada.common.model.BaseModelWithId;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDateTime;

public class CircleTopicContent extends BaseModelWithId implements Serializable {
    @ApiModelProperty(value="圈子专题ID")
    private Long circleTopicId;

    @ApiModelProperty(value="作者")
    private String author;

    @ApiModelProperty(value="专题标题")
    private String title;

    @ApiModelProperty(value="发布状态 0：未发布 1：已发布 2：已下架")
    private Integer publishStatus;

    @ApiModelProperty(value="发布时间")
    private LocalDateTime publishTime;

    @ApiModelProperty(value="专题内容")
    private String content;

    private static final long serialVersionUID = 1L;

    public Long getCircleTopicId() {
        return circleTopicId;
    }

    public void setCircleTopicId(Long circleTopicId) {
        this.circleTopicId = circleTopicId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}