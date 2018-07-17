package com.esther.code.modules.staticaop.decoupling;


import com.esther.code.modules.staticaop.Hello;
import com.esther.code.modules.staticaop.IHello;

public class DynamicHelloProxyTest {

	public static void main(String[] args) {
		IHello iHello=(IHello) new DynamicHelloProxy().bind(new LoggerOperation(),new Hello());
		iHello.sayHello("esther");
		iHello.sayGoogBye("esther"); 
	}			

}
