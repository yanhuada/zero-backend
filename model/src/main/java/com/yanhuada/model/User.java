package com.yanhuada.model;

import com.yanhuada.common.model.BaseModelWithId;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class User extends BaseModelWithId implements Serializable {
    @ApiModelProperty(value="用户微信openId")
    private String openId;

    @ApiModelProperty(value="昵称")
    private String nickname;

    @ApiModelProperty(value="用户头像")
    private String avatar;

    @ApiModelProperty(value="电子邮箱")
    private String email;

    @ApiModelProperty(value="手机号")
    private String phone;

    @ApiModelProperty(value="盐值")
    private String salt;

    @ApiModelProperty(value="性别，0：未知，1：男，2：女")
    private Integer sex;

    @ApiModelProperty(value="地址")
    private String location;

    @ApiModelProperty(value="是否启用")
    private Boolean ifEnable;

    @ApiModelProperty(value="是否为作者")
    private Boolean ifAuthor;

    @ApiModelProperty(value="是否为客服")
    private Boolean ifCustomerService;

    @ApiModelProperty(value="登陆密码")
    private String password;

    private static final long serialVersionUID = 1L;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public Boolean getIfEnable() {
        return ifEnable;
    }

    public void setIfEnable(Boolean ifEnable) {
        this.ifEnable = ifEnable;
    }

    public Boolean getIfAuthor() {
        return ifAuthor;
    }

    public void setIfAuthor(Boolean ifAuthor) {
        this.ifAuthor = ifAuthor;
    }

    public Boolean getIfCustomerService() {
        return ifCustomerService;
    }

    public void setIfCustomerService(Boolean ifCustomerService) {
        this.ifCustomerService = ifCustomerService;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}