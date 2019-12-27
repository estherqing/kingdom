package com.vivo.jovi.scene.common.dal.entity;

import java.util.Date;

public class UserImeisEntity {
    private Integer id;

    private String userId;

    private String userName;

    private String imeis;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getImeis() {
        return imeis;
    }

    public void setImeis(String imeis) {
        this.imeis = imeis;
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

    public UserImeisEntity() {
    }

    public UserImeisEntity(String userId, String userName, String imeis) {
        this.userId = userId;
        this.userName = userName;
        this.imeis = imeis;
    }
}