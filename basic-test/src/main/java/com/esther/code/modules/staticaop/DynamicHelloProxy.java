package com.esther.code.modules.staticaop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 只要你是采用面向接口编程,那么,你的任何对象的方法执行之前要加上记录日志的操作都是可以的.
 * 他(DynaPoxyHello)自动去代理执行被代理对象(Hello)中的每一个方法,
 * 一个java.lang.reflect.InvocationHandler接口就把我们的代理对象和被代理对象解藕了.
 * @author E2
 *
 */
public class DynamicHelloProxy implements InvocationHandler {

	private Object delegate;

	public Object bind(Object delegate) {
		this.delegate = delegate;
		// 获取代理对象
		return Proxy.newProxyInstance(this.delegate.getClass().getClassLoader(),
				this.delegate.getClass().getInterfaces(), this);
	}
	
    @Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null;
		try {
			// 执行原来的方法之前记录日志
			Logger.logging(Level.DEBUGE, method.getName() + " Method Start!");

			// JVM通过这条语句执行原来的方法(反射机制)
			result = method.invoke(this.delegate, args);
			// 执行原来的方法之后记录日志
			Logger.logging(Level.INFO, method.getName() + " Method End!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 返回方法返回值给调用者
		return result;
	}

}
