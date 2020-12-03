package com.yanhuada.model;

import com.yanhuada.common.model.BaseModelWithId;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class SystemMessage extends BaseModelWithId implements Serializable {
    @ApiModelProperty(value="标题")
    private String title;

    @ApiModelProperty(value="内容")
    private String content;

    @ApiModelProperty(value="跳转链接")
    private String url;

    @ApiModelProperty(value="url文本解释")
    private String urlText;

    private static final long serialVersionUID = 1L;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getUrlText() {
        return urlText;
    }

    public void setUrlText(String urlText) {
        this.urlText = urlText == null ? null : urlText.trim();
    }
}