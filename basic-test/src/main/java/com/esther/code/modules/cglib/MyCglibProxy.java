package com.esther.code.modules.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author esther
 * 2018-04-25 15:30
 * $DESCRIPTION}
 */

public class MyCglibProxy implements MethodInterceptor {

//    private Logger log = LogManager.getLogger(MyCglibProxy.class);

    private String name;

    public MyCglibProxy(String name) {
        this.name = name;
    }

    public Object intercept(Object object, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("调用的方法是：" + method.getName());
        System.out.println("实际调用者是： " + object.getClass());
        for (Object obj : objects) {
            System.out.println("方法参数类型为：" + obj.getClass());
        }

        if (!name.equals("张三")) {
            System.out.println("权限不够");
            return null;
        }
        Object result = methodProxy.invokeSuper(object, objects);
        System.out.println("这是方法后");
        return result;
    }
}