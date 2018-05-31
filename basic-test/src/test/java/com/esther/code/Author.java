package com.esther.code;

import org.hibernate.validator.constraints.Email;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author esther
 * 2018-05-29 17:54
 * $DESCRIPTION}
 */

public class Author {
    @NotNull
    @Size(min = 6, max = 15)
   // @Pattern(regexp = "([a-zA-Z]\d*)")
    private String username;
    @NotNull
    @Size(min = 6, max = 20)
    private String password;
    @NotNull
    private String nickname;
    @Email
    private String email;
    @Min(0)
    private int age;
    @Size(max = 500)
    private String address;
    @Past
    @NotNull
    private Date birthday;
    @Valid
    @NotNull
    private List<Article> articles = new ArrayList<>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
