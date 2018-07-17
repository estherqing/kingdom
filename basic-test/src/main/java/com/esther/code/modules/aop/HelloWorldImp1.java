package com.esther.code.modules.aop;

public class HelloWorldImp1 implements HelloWorld{

	@Override
	public void printHelloWorld() {
		// TODO Auto-generated method stub
		System.out.println("Enter HelloWorldImpl1.printHelloWorld()");
	}

	@Override
	public void doPrint() {
		// TODO Auto-generated method stub
		System.out.println("Enter HelloWorldImpl1.doPrint()");
        return ;
	}

}
