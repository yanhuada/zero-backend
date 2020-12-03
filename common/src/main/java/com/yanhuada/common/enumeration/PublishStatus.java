package com.yanhuada.common.enumeration;

/**
 * @author yanhuada
 * CREATE ON 2020/8/14 22:22
 */
public enum PublishStatus {

    /**
     * 圈子主题状态
     */

    UNPUBLISHED(0, "未发布"),
    PUBLISHED(1, "已发布"),
    OFF(2, "已下架");

    private int code;
    private String msg;

    PublishStatus(int code, String msg) {
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
