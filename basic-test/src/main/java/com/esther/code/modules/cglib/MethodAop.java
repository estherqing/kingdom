package com.esther.code.modules.cglib;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MethodAop {
	@Before("execution(* com.esther.code.modules.cglib.Hello.sayHello(..))")
    public void before() {
        System.out.println("方法调用前。。。。。。。");
    }
}
