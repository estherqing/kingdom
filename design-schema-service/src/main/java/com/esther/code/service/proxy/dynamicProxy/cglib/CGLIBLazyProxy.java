package com.esther.code.service.proxy.dynamicProxy.cglib;

import net.sf.cglib.proxy.LazyLoader;

/**
 * @author esther
 * 2018-04-27 15:14
 * 延迟加载代理类
 * 通过使用LazyLoader，可以实现延迟加载，即在没有访问对象的字段或方法之前并不加载对象，只有当要访问对象的字段或方法时才进行加载。
 */

public class CGLIBLazyProxy implements LazyLoader{

    //拦截Bean的加载，本方法会延迟处理
    @Override
    public Object loadObject() throws Exception {
        System.out.println("开始延迟加载!");
        Hello hello=new Hello();
        hello.setName("esther");
        hello.sayHello(hello.getName());
        return hello;
    }
}
