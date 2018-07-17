package com.esther.code.modules.staticaop;

import org.springframework.aop.support.AopUtils;

public class HelloProxyTest {

	public static void main(String[] args) {
		//hello对象是被HelloProxy这个所谓的代理态所创建的
		IHello iHello = new HelloProxy(new Hello());
		iHello.sayHello("esther");
		iHello.sayGoogBye("esther");

		System.out.println(iHello.getClass());
		System.out.println(iHello.getClass().getSuperclass());
		System.out.println("isJdkDynamicProxy:" + AopUtils.isJdkDynamicProxy(iHello));
		System.out.println("isCglibProxy:" + AopUtils.isCglibProxy(iHello));

	}

}
