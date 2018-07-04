package com.esther.code.model;

/**
 * @author esther
 * 2018-06-26 15:09
 * $DESCRIPTION}
 */

public class Test {
    private Integer id;
    private String name;
    private Integer age;

    public Test() {
    }

    public Test(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
