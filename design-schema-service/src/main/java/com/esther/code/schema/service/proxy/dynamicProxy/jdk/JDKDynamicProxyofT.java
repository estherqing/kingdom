package com.esther.code.schema.service.proxy.dynamicProxy.jdk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author esther
 * 2018-04-25 16:24
 *
 * 实现InvocationHandler接口，该接口定义了一个 invoke(Object proxy, Method method, Object[] args)的方法，
 * 1,proxy是最终生成的代理实例，一般不会用到；
 * 2,method是被代理目标实例的某个具体方法，通过它可以发起目标实例方法的反射调用；
 * 3,args是通过被代理实例某一个方法的入参，在方法反射调用时使用。
 */

public class JDKDynamicProxyofT<T> implements InvocationHandler {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //被代理类的对象
    private T delegate;

    //绑定被代理对象
    public T bind(T delegate) {
        this.delegate = delegate;
        //返回实现了被代理类所实现的所有接口的Object对象，即动态代理，需要强制转型
        //创建代理对象，注意这里被代理的对象类必须实现至少一个接口
        return (T)Proxy.newProxyInstance(delegate.getClass().getClassLoader(), delegate.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        logger.info(System.currentTimeMillis() + "：开始！");
        Object object = method.invoke(this.delegate, args);
        if (method.getName().matches("say[a-zA-Z0-9]+")) {
            logger.info("这是一个以say开头的方法！");
        }
        logger.info(System.currentTimeMillis() + "：结束！");
        return object;
    }
}
