package com.yanhuada.common.model;

/**
 * @author yanhuada
 * CREATE ON 2020/8/22 15:46
 */
public enum SystemMessageType {


    /**
     * 系统信息类型
     */


    JION_CIRCLE(0, SystemMessageConstant.JION_CIRCLE_TITLE, SystemMessageConstant.JION_CIRCLE_CONTENT, SystemMessageConstant.JION_CIRCLE_URL, SystemMessageConstant.JION_CIRCLE_URL_TEXT),

    ;

    private int code;
    private String title;
    private String content;
    private String url;
    private String urlText;

    SystemMessageType(int code, String title, String content, String url, String urlText) {
        this.code = code;
        this.title = title;
        this.content = content;
        this.url = url;
        this.urlText = urlText;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlText() {
        return urlText;
    }

    public void setUrlText(String urlText) {
        this.urlText = urlText;
    }
}
