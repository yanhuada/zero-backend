package com.yanhuada.platform.jwt;

import io.jsonwebtoken.expand.model.IUser;

/**
 * @author yanhuada
 * CREATE ON 2020/3/14 18:00
 */
public class JwtUser implements IUser {

    static final String USER_ID_KEY = "userId";
    static final String ASSISTANT_ID_KEY = "assistantId";
    static final String USER_EMAIL_KEY = "email";
    static final String USER_NICKNAME_KEY = "nickname";
    static final String USER_HEAD_IMG_URL_KEY = "headimgurl";
    static final String WX_OPENID_KEY = "wxOpenid";
    static final String WX_IS_ASSISTANT_KEY = "isAssistant";
    static final String FACEBOOK_ID_KEY = "facebookId";
    static final String ASSISTANT_GRADE = "grade";
    static final String LOGIN_MODE = "loginMode";
    static final String USER_SEX = "sex";

    private Long userId;
    //助理ID
    private Long assistantId;
    private String email;
    private String nickname;
    private String headimgurl;
    //性别 0:未知 1:男 2:女
    private Integer sex = 0;
    private String wxOpenid;
    private String facebookId;
    //是否为助理 1:是 0:否
    private Boolean isAssistant;
    //等级 1:专业 2:高级 3：日常
    private Integer grade;
    private Boolean isAnonymous = true;
    private String uuid;
    private Integer channel = 0;
    private long expiredSeconds;
    //登录方式 0:未登陆 1：邮箱登录，2：微信登录，3：facebook登录
    private Integer loginMode = 0 ;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public String getWxOpenid() {
        return wxOpenid;
    }

    public void setWxOpenid(String wxOpenid) {
        this.wxOpenid = wxOpenid;
    }

    @Override
    public Boolean getAnonymous() {
        return isAnonymous;
    }

    public void setAnonymous(Boolean anonymous) {
        isAnonymous = anonymous == null ? true : anonymous;
    }

    @Override
    public String getId() {
        return this.isAnonymous ? "uuid:" + this.uuid : String.format("%d:%d", this.channel, this.getUserId());
    }

    @Override
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public Integer getChannel() {
        return channel;
    }

    public void setChannel(Integer channel) {
        this.channel = channel;
    }

    @Override
    public String getSubject() {
        return nickname;
    }

    @Override
    public long getExpiredSeconds() {
        return expiredSeconds;
    }

    public void setExpiredSeconds(long expiredSeconds) {
        this.expiredSeconds = expiredSeconds;
    }

    public Boolean getIsAssistant() {
        return isAssistant;
    }

    public void setIsAssistant(Boolean assistant) {
        isAssistant = assistant;
    }

    public Long getAssistantId() {
        return assistantId;
    }

    public void setAssistantId(Long assistantId) {
        this.assistantId = assistantId;
    }

    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Boolean getAssistant() {
        return isAssistant;
    }

    public void setAssistant(Boolean assistant) {
        isAssistant = assistant;
    }

    public Integer getLoginMode() {
        return loginMode;
    }

    public void setLoginMode(Integer loginMode) {
        this.loginMode = loginMode;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}
