package com.esther.code.modules.aop;

import org.springframework.aop.support.AopUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class aopTest {

	// @Test
	public static void main(String[] args) {

		String[] xmls = { "/config/spring-servlet.xml", "/config/applicationContext.xml" };
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext(xmls);

		HelloWorld hw1 = (HelloWorld) ctx.getBean("helloWorldImp1");
		HelloWorld hw2 = (HelloWorld) ctx.getBean("helloWorldImp2");

		hw1.printHelloWorld();
		System.out.println();
		hw1.doPrint();

		System.out.println("isJdkDynamicProxy:" + AopUtils.isJdkDynamicProxy(hw1));
		System.out.println("isCglibProxy:" + AopUtils.isCglibProxy(hw1));

		System.out.println();
		hw2.printHelloWorld();
		System.out.println();
		hw2.doPrint();

		HelloWorldImp1 hwpl1 = (HelloWorldImp1) ctx.getBean("helloWorldImp1");
		hwpl1.printHelloWorld();
		hwpl1.doPrint();
	}
}
