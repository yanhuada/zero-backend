package com.yanhuada.exception;

/**
 * @author vardar
 * CREATE ON 2020/3/14 18:00
 */
public enum ErrorCode {
    /**
     *
     */
    EMAIL_ERROR(600,"操作成功，但邮件下发失败"),
    CAPTCHA_ERROR(601, "验证码错误"),
    USER_NOT_FONT(7001,"该用户尚未注册"),
    USER_LACK_OF_BALANCE(7002,"余额不足"),
    JWT_ILLEGAL_USER(10001, "非法的用户类型"),
    JWT_USERID_IS_NULL(10002, "用户ID不可为空"),
    JWT_UUID_IS_NULL(10003, "缺少唯一标识"),

    ADMIN_NOT_FOUND(20001, "管理员不存在"),
    ADMIN_EMAIL_USED(20002,"该邮箱已被占用"),
    PASSWORD_ERROR(20003,"密码错误"),
    ADMIN_NAME_USED(20004,"该账号已存在"),

    EBOOK_USED(30001,"电子书已存在"),
    EBOOK_NOT_FOUND(30002,"电子书不存在"),
    RESUME_TAP_USED(40001,"简历标签已经被占用"),
    RESUME_TAP_NOT_FOUND(40002,"简历标签不存在"),
    RESUME_USED(40003,"简历已经被占用"),
    RESUME_NOT_FOUND(40004,"简历不存在"),
    SOFTWARE_TYPE_USED(50001,"软件类型已被占用"),
    SOFTWARE_TYPE_NOT_FOUND(50002,"软件类型不存在"),
    SOFTWARE_USED(50003,"软件已经被占用"),
    SOFTWARE_NOT_FOUND(50004,"软件不存在"),
    SOFTWARE_TYPE_USING(50005,"还存在该类型的软件，可删除相关软件再进行这操作"),
    MESSAGE_NOT_FOUND(60001,"信息已被删除"),

    BANNER_NOT_FOUND(70001,"该轮播图不存在"),

    STORE_NOT_FOUND(200000,"该文件不存在"),
    STORE_TYPE_USED(200001,"该类型已存在"),
    STORE_TYPE_PARENT_NOT_FOUND(200002,"该父类型不存在"),
    STORE_TYPE_NOT_FOUND(200003,"该文件类型不存在"),

    CIRCLE_NAME_USED(30001,"圈子已经存在"),
    CIRCLE_NOT_FOUND(30002,"圈子不存在"),
    CIRCLE_TOPIC_NOT_FOUND(30003,"圈子主题不存在"),
    CIRCLE_TOPIC_NAME_USED(30004,"该专题已存在"),
    CIRCLE_TOPIC_CONTENT_NOT_FOUND(30005,"该专题内容不存在"),
    CIRCLE_USER_EXISTS(30006,"你已经加入该圈子了"),
    CIRCLE_RESOURCE_NOT_FOUND(30007,"该圈子资源不存在"),

    WEEKLY_NOT_FOUND(30100,"周刊不存在"),

    AUTHOR_NOT_FOUND(30200,"作者不存在"),
    AUTHOR_ALREADY_EXISTS(30201,"该用户已是作者"),

    ART_SPEAK_TYPE_EXISTS(30300,"该句子类型已存在"),
    ART_SPEAK_NOT_FOUND(30301,"该句子不存在"),
    ART_SPEAK_TYPE_NOT_FOUND(30302,"该句子类型不存在"),

    COMMON_PROBLEM_NOT_FOUND(30400,"该常见问题不存在"),

    SMALL_VIDEO_NOT_FOUND(30500,"视频不存在"),
    ;
    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
