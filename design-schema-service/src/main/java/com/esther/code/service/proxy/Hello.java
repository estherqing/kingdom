package com.esther.code.service.proxy;

import com.esther.code.api.proxy.IHello;

/**
 * @author esther
 * 2018-04-25 16:11
 * 核心业务操作类
 */
public class Hello implements IHello {
    @Override
    public void sayHello(String name) {
        System.out.println("你好："+name);
    }

}