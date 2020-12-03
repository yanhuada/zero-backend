package com.yanhuada.model;

import com.yanhuada.common.model.BaseModelWithId;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class SystemMessageRecord extends BaseModelWithId implements Serializable {
    @ApiModelProperty(value="用户ID")
    private Long userId;

    @ApiModelProperty(value="系统信息ID: 为0时，则不是管理后台发送")
    private Long systemMessageId;

    @ApiModelProperty(value="系统信息标题")
    private String systemMessageTitle;

    @ApiModelProperty(value="系统信息内容")
    private String systemMessageContent;

    @ApiModelProperty(value="系统信息跳转链接")
    private String systemMessageUrl;

    @ApiModelProperty(value="系统信息url文本解释")
    private String systemMessageUrlText;

    @ApiModelProperty(value="是否阅读 0：未读 1：已读")
    private Boolean ifRead;

    private static final long serialVersionUID = 1L;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getSystemMessageId() {
        return systemMessageId;
    }

    public void setSystemMessageId(Long systemMessageId) {
        this.systemMessageId = systemMessageId;
    }

    public String getSystemMessageTitle() {
        return systemMessageTitle;
    }

    public void setSystemMessageTitle(String systemMessageTitle) {
        this.systemMessageTitle = systemMessageTitle == null ? null : systemMessageTitle.trim();
    }

    public String getSystemMessageContent() {
        return systemMessageContent;
    }

    public void setSystemMessageContent(String systemMessageContent) {
        this.systemMessageContent = systemMessageContent == null ? null : systemMessageContent.trim();
    }

    public String getSystemMessageUrl() {
        return systemMessageUrl;
    }

    public void setSystemMessageUrl(String systemMessageUrl) {
        this.systemMessageUrl = systemMessageUrl == null ? null : systemMessageUrl.trim();
    }

    public String getSystemMessageUrlText() {
        return systemMessageUrlText;
    }

    public void setSystemMessageUrlText(String systemMessageUrlText) {
        this.systemMessageUrlText = systemMessageUrlText == null ? null : systemMessageUrlText.trim();
    }

    public Boolean getIfRead() {
        return ifRead;
    }

    public void setIfRead(Boolean ifRead) {
        this.ifRead = ifRead;
    }
}