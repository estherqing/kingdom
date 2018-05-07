package com.esther.code.proxy.dynamicProxy.cglib;

import com.esther.code.schema.service.proxy.dynamicProxy.cglib.CGLIBLazyProxy;
import com.esther.code.schema.service.proxy.dynamicProxy.cglib.Hello;
import net.sf.cglib.proxy.Enhancer;

/**
 * @author esther
 * 2018-04-27 15:17
 * $DESCRIPTION}
 */

public class CGLIBLazyProxyTest {
    public static void main(String[] args) {
        Hello hello= (Hello) Enhancer.create(Hello.class, new CGLIBLazyProxy());
        System.out.println("...............");
        System.out.println(hello.getName());
    }
}
