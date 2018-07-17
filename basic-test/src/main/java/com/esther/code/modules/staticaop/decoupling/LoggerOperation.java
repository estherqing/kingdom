package com.esther.code.modules.staticaop.decoupling;


import com.esther.code.modules.staticaop.Level;
import com.esther.code.modules.staticaop.Logger;

import java.lang.reflect.Method;

public class LoggerOperation implements IOperation {

	@Override
	public void start(Method method) { 
		  Logger.logging(Level.DEBUGE, method.getName() + " Method Start!");

	}

	@Override
	public void end(Method method) { 
		  Logger.logging(Level.DEBUGE, method.getName() + " Method End!"); 
 }

}
