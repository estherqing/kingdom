package com.esther.code.proxy.dynamicProxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author esther
 * 2018-06-26 14:00
 * $DESCRIPTION}
 */

public class CGLIBDemo {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(CGLIBDemo.class); //① 设置需要创建子类的类
        // 设置单一回调对象，在回调中拦截对目标方法的调用
        enhancer.setCallback(new MethodInterceptorImpl());
        CGLIBDemo demo = (CGLIBDemo) enhancer.create();
        demo.test();
        System.out.println(demo);// 先调用toString()方法，再调用hashCode()方法
        System.out.println("我们得到的bean是：" + demo.getClass());
        System.out.println("实际调用者的父类：" + demo.getClass().getSuperclass());
    }

    public void test() {
        System.out.println("CGLIBDemo test()");
    }

    private static class MethodInterceptorImpl implements MethodInterceptor {
        @Override
        public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
            System.out.println("before invoke " + method);
            Object result = methodProxy.invokeSuper(o, args);
            System.out.println("after invoke " + method);
            return result;
        }
    }
}
