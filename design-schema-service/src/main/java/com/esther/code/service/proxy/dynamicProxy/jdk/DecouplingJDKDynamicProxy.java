package com.esther.code.service.proxy.dynamicProxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author esther
 * 2018-04-26 17:39
 * $DESCRIPTION}
 */

public class DecouplingJDKDynamicProxy<T, V> implements InvocationHandler {
    private T object;
    private V delegate;

    public V bind(T object, V delegate) {
        this.object = object;
        this.delegate = delegate;
        return (V) Proxy.newProxyInstance(this.delegate.getClass().getClassLoader(), this.delegate.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Class<? extends Object> clazz = this.object.getClass();
        Method log = clazz.getDeclaredMethod("log", new Class[]{Method.class});
        log.invoke(this.object, new Object[]{method});
        Object result = method.invoke(this.delegate, args);
        return result;
    }
}
