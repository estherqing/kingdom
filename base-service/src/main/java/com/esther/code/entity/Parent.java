package com.esther.code.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;

/**
 * @author esther
 * 2018-05-17 10:42
 * $DESCRIPTION}
 */

public class Parent {
    private int id;
    private String name;
    private double salary;
    private int age;
    @Value("浙江省")
    private String address;
    @Resource(name = "child")
    @Autowired(required = false)
    private Child child;

    public Parent() {
    }

    public Parent(int id, String name, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    // init方法
    public void init() {
        this.age = 25;
    }

    // destroy方法
    public void cleanup() {
        id = 0;
        name = "";
        salary = 0;
        age = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    @Required
    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    @Override
    public String toString() {
        return "Parent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", child=" + child +
                '}';
    }
}
