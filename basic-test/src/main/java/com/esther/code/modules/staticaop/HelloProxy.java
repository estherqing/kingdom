package com.esther.code.modules.staticaop;

public class HelloProxy implements IHello {
	private IHello iHello;

	public HelloProxy(IHello iHello) {
		this.iHello = iHello;
	}

	@Override
	public void sayHello(String name) {
		Logger.logging(Level.DEBUGE, "sayHello method start.");
		iHello.sayHello(name);
		Logger.logging(Level.INFO, "sayHello method end!");
	}

	@Override
	public void sayGoogBye(String name) {
		Logger.logging(Level.DEBUGE, "sayGoogBye method start.");
		iHello.sayGoogBye(name);
		Logger.logging(Level.INFO, "sayGoogBye method end!");
	}

}
