package com.esther.code.modules.staticaop;

import org.springframework.aop.support.AopUtils;

public class DynamicHelloProxyTest {

	public static void main(String[] args) {
		IHello iHello=(IHello) new DynamicHelloProxy().bind(new Hello());
		iHello.sayHello("esther");
		iHello.sayGoogBye("esther");
		System.out.println(iHello.getClass());
		System.out.println(iHello.getClass().getSuperclass());
		System.out.println(iHello.getClass().getSuperclass().getSuperclass());
		System.out.println("isJdkDynamicProxy:" + AopUtils.isJdkDynamicProxy(iHello));
		System.out.println("isCglibProxy:" + AopUtils.isCglibProxy(iHello));

	}

}
