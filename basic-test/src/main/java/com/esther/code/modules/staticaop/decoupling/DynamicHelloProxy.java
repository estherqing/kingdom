package com.esther.code.modules.staticaop.decoupling;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 只要你是采用面向接口编程,那么,你的任何对象的方法执行之前要加上记录日志的操作都是可以的.
 * 他(DynaPoxyHello)自动去代理执行被代理对象(Hello)中的每一个方法,
 * 一个java.lang.reflect.InvocationHandler接口就把我们的代理对象和被代理对象解藕了.
 * 这个DynaPoxyHello对象只能跟我们去在方法前后加上日志记录的操作.
 * 我们能不能把DynaPoxyHello对象和日志操作对象(Logger)解藕呢?
 * 
 * InvocationHandler是JDK动态代理的核心，生成的代理对象的方法调用都会委托到InvocationHandler.invoke()方法
 * JdkDynamicAopProxy是通过接口实现动态代理类，主要方法是getProxy(ClassLoader classLoader)，代理类生成之后再调用目标方法时就会调用invoke方法。
 * 
 * @author E2
 *
 */
public class DynamicHelloProxy implements InvocationHandler {

	private Object proxy;
	private Object delegate;

	public Object bind(Object proxy, Object delegate) {
		this.proxy = proxy;
		this.delegate = delegate;
		return Proxy.newProxyInstance(this.delegate.getClass().getClassLoader(),
				this.delegate.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null;
		try {
			// 反射得到操作者的实例
			Class<? extends Object> clazz = this.proxy.getClass();
			// 1:a) 反射得到操作者的Start方法
			Method start = clazz.getDeclaredMethod("start", new Class[] { Method.class });
			// 1:b) 反射执行start方法
			start.invoke(this.proxy, new Object[] { method });
			// 2: 执行要处理对象的原本方法
			result = method.invoke(this.delegate, args);
			// 3:a) 反射得到操作者的end方法
			Method end = clazz.getDeclaredMethod("end", new Class[] { Method.class });
			// 3:b) 反射执行end方法
			end.invoke(this.proxy, new Object[] { method });

		} catch (Exception e) {
			e.printStackTrace();
		}
		// 返回方法返回值给调用者
		return result;
	}

}
