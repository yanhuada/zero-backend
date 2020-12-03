package com.yanhuada.model;

import com.yanhuada.common.model.BaseModelWithId;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class Admin extends BaseModelWithId implements Serializable {
    @ApiModelProperty(value="名称")
    private String name;

    @ApiModelProperty(value="邮箱")
    private String email;

    @ApiModelProperty(value="手机号")
    private String phone;

    @ApiModelProperty(value="盐值")
    private String salt;

    @ApiModelProperty(value="是否被锁定")
    private Boolean ifLock;

    @ApiModelProperty(value="是否超级管理员 0：普通管理员 1：超级管理员")
    private Boolean ifSuper;

    @ApiModelProperty(value="是否启用")
    private Boolean ifEnable;

    @ApiModelProperty(value="登陆密码")
    private String password;

    private static final long serialVersionUID = 1L;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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

    public Boolean getIfLock() {
        return ifLock;
    }

    public void setIfLock(Boolean ifLock) {
        this.ifLock = ifLock;
    }

    public Boolean getIfSuper() {
        return ifSuper;
    }

    public void setIfSuper(Boolean ifSuper) {
        this.ifSuper = ifSuper;
    }

    public Boolean getIfEnable() {
        return ifEnable;
    }

    public void setIfEnable(Boolean ifEnable) {
        this.ifEnable = ifEnable;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}