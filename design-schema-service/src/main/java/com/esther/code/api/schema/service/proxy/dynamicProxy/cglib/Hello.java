package com.esther.code.api.schema.service.proxy.dynamicProxy.cglib;

/**
 * @author esther
 * 2018-04-25 16:11
 * 核心业务操作类
 */
public class Hello{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sayHello(String name) {
        System.out.println("你好："+name);
    }
}