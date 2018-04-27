package com.esther.code.proxy.dynamicProxy.cglib;

import com.esther.code.ProxyType;
import com.esther.code.service.proxy.dynamicProxy.cglib.CGLIBDynamicProxy;
import com.esther.code.service.proxy.dynamicProxy.cglib.Hello;

/**
 * @author esther
 * 2018-04-25 16:24
 * $DESCRIPTION}
 */

public class CGLIBDynamicProxyTest {
    public static void main(String[] args) {
        CGLIBDynamicProxy proxy=new CGLIBDynamicProxy();
        Hello hello=(Hello)proxy.getProxy(Hello.class);
        hello.sayHello("esther");
        ProxyType.getProxyType(hello);
    }
}
