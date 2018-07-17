package com.esther.code.modules.test;

import com.esther.code.common.utils.DateUtils;
import com.esther.code.common.utils.HttpClientUtil;
import com.esther.code.modules.aop.HelloWorld;
import com.esther.code.modules.aop.HelloWorldImp1;
import com.esther.code.modules.aop.HelloWorldImp2;
import com.esther.code.modules.entity.TestModel;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.propertyeditors.CustomDateEditor;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BinderTest {
	public static void main(String[] args) {
		// testBinder();
		// test();
		HelloWorld hw1 = new HelloWorldImp1();
		HelloWorld hw2 = new HelloWorldImp2();
		hw1.printHelloWorld();
		System.out.println();
		hw1.doPrint();
 
		System.out.println();
		hw2.printHelloWorld();
		System.out.println();
		hw2.doPrint();
	}

	@SuppressWarnings("unused")
	private static void testBinder() {
		// String url =
		// "http://localhost:8080/springTest/binder/testClass.do?age=10&name=jack";
		String url = "http://localhost:8080/springTest/login.do?username=jack";
		HttpClientUtil.sendHttpsGet(url);
	}

	@SuppressWarnings("unused")
	private static void test() {

		TestModel tm = new TestModel();
		BeanWrapper bw = new BeanWrapperImpl(tm);
		bw.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
		bw.setPropertyValue("birth", "2016-01-01");
		// bw.setPropertyValue("good", "on");
		bw.setPropertyValue("good", "1");
		// bw.setPropertyValue("good", "true");
		// bw.setPropertyValue("good", "yes");
		double days = DateUtils.getDistanceOfTwoDate(tm.getBirth(), new Date());
		System.out.println(tm);
		System.out.println(days);

	}

}
