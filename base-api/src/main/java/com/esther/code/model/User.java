package com.esther.code.model;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
    private static final long serialVersionUID = 5993286892322436568L;

    private Integer id;

    private String userName;

    private String password;

    private String userRealName;

    private String address;

    private String sex;

    private Integer age;

    private Date createDate;

    public User(){}

    public User(Integer id,String userName){
        this.id=id;
        this.userName=userName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName == null ? null : userRealName.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", userRealName='" + userRealName + '\'' +
                ", address='" + address + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", createDate=" + createDate +
                '}';
    }
}