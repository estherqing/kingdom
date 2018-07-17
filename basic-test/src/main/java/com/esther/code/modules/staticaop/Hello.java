package com.esther.code.modules.staticaop;

public class Hello implements IHello {

	@Override
	public void sayHello(String name) {
		System.out.println("Hello " + name);
		this.sayGoogBye(name);// 与sayGoogBye()等价，this是指目标对象，不走代理
	}

	@Override
	public void sayGoogBye(String name) {
		System.out.println(name + " Goodbye");
	}

	public void print(String name) {
		System.out.println("Print:" + name);
	}
}
