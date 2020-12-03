package com.yanhuada.common.enumeration;

import lombok.Data;
import lombok.Setter;

import java.util.Objects;

/**
 * @author yanhuada
 * CREATE ON 2020/8/14 17:53
 */

public enum WeeklyStatus {

    /**
     * 周刊状态
     */

    UNPUBLISHED(0, "未发布"),
    PUBLISHED(1, "已发布"),
    OFF(2, "已下架");

    private int code;
    private String msg;

    WeeklyStatus(int code, String msg) {
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

    public static WeeklyStatus findByCode(Integer code) {
        for (WeeklyStatus weeklyStatus : values()) {
            if (Objects.equals(code, weeklyStatus.getCode())) {
                return weeklyStatus;
            }
        }
        return null;
    }
}
