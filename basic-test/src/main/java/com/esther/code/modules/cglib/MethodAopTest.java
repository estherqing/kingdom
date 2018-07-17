package com.esther.code.modules.cglib;

import org.junit.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MethodAopTest {

	static ApplicationContext context = null;
	static {
		String[] xmls = { "/config/spring-servlet.xml", "/config/applicationContext.xml" };
		context = new ClassPathXmlApplicationContext(xmls);
	}

	@Test
	public void aspectTest() {
		Hello hello = context.getBean("hello", Hello.class);
		hello.sayHello("esther");
		System.out.println("isJdkDynamicProxy:" + AopUtils.isJdkDynamicProxy(hello));
		System.out.println("isCglibProxy:" + AopUtils.isCglibProxy(hello));
	}

}
