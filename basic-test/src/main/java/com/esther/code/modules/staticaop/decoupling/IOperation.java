package com.esther.code.modules.staticaop.decoupling;

import java.lang.reflect.Method;

public interface IOperation {
	void start(Method method);

	void end(Method method);

}
