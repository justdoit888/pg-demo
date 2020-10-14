package com.sunjz.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

//@Data
public class TechUser implements Serializable {
    /**用户id*/
    private Long userId;

    /**用户名 - 均为手机号*/
    private String userName;
    /**密码*/
    private String password;
    /**登录状态*/
    private Integer loginState;
    /**会员等级*/
    private Integer level;

    private Date createTime;

    private Date updateTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TechUser)) return false;
        TechUser techUser = (TechUser) o;
        return Objects.equals(userId, techUser.userId) &&
                Objects.equals(userName, techUser.userName) &&
                Objects.equals(password, techUser.password) &&
                Objects.equals(loginState, techUser.loginState) &&
                Objects.equals(level, techUser.level) &&
                Objects.equals(createTime, techUser.createTime) &&
                Objects.equals(updateTime, techUser.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, password, loginState, level, createTime, updateTime);
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getLoginState() {
        return loginState;
    }

    public void setLoginState(Integer loginState) {
        this.loginState = loginState;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}