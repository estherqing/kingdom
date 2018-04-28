package com.esther.code.proxy;

import org.springframework.aop.support.AopUtils;

/**
 * @author esther
 * 2018-04-25 16:36
 * $DESCRIPTION}
 */

public class ProxyType {

    public static void getProxyType(Object object){
        System.out.println("isJdkDynamicProxy:" + AopUtils.isJdkDynamicProxy(object));
        System.out.println("isCglibProxy:" + AopUtils.isCglibProxy(object));
    }
}
