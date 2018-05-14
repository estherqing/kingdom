package com.esther.code.proxy.dynamicProxy.jdk;

import com.esther.code.proxy.ProxyType;
import com.esther.code.api.schema.proxy.IHello;
import com.esther.code.api.schema.service.proxy.Hello;
import com.esther.code.api.schema.service.proxy.dynamicProxy.jdk.*;

/**
 * @author esther
 * 2018-04-25 16:24
 * 动态代理模式可以让我们在不改变原来代码结构的情况下，对原来的“真实方法”进行扩展、增强其功能，并且可以达到控制被代理对象的行为。
 * 动态代理模式运用的知识点就是Java的反射机制
 */

public class JDKDynamicProxyTest {
    public static void main(String[] args) {
        IHello hello=new Hello();
        IHello iHello =   (IHello) new JDKDynamicProxy().bind(hello);
        iHello.sayHello("esther");

        System.out.println("............................");
        IHello iHello2 =   new JDKDynamicProxyofT<IHello>().bind(hello);
        iHello2.sayHello("esther");

        System.out.println("............................");
        IHello iHello3 =   new DecouplingJDKDynamicProxy<ILog,IHello>().bind(new Log(),hello);
        iHello3.sayHello("esther");

        ProxyType.getProxyType(iHello);
    }
}
