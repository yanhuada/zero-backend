package com.yanhuada.common.enumeration;

/**
 * @author yanhuada
 * CREATE ON 2020/9/3 21:35
 */
public enum CommentType {

    /**
     * 评论类型
     */
    TOPIC(0, "主题评论"),
    WEEKLY(1, "周刊评论"),
    VIDEO(2, "视频评论");

    private int code;
    private String msg;

    CommentType(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
