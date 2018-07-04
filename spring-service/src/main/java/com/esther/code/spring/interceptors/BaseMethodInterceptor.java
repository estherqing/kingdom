package com.esther.code.spring.interceptors;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author esther
 * 2018-06-20 14:41
 * 拦截器
 */
@Aspect
@Component
@Order(1)
public class BaseMethodInterceptor {

    @Before("execution(* com.esther.code.spring.service.impl..*.*(..))")
    public void before() {
        System.out.println("方法调用前。。。。。。。");
    }

    @Pointcut("execution(* com.esther.code.spring.service.impl..*.*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint) {
        System.out.println("[AOP before] 进入方法：" + joinPoint.getSignature().getName());
    }

    @AfterThrowing(pointcut = "pointCut()", throwing = "throwable")
    public void afterThrowing(Throwable throwable) {
        System.out.println("[AOP afterthrowing]:" + throwable);
    }

    @After("pointCut()")
    public void doAfter(JoinPoint joinPoint) {
        System.out.println("[AOP After Advice]");
    }

    @AfterReturning(returning = "returnVal", pointcut = "pointCut()")
    public void afterReturn(JoinPoint joinPoint, Object returnVal) {
        System.out.println("[AOP AfterReturning Advice]获取目标方法:" + joinPoint.getSignature().getName() + ",返回值:" + returnVal);
    }


    @Around("pointCut()")
    public Object around(ProceedingJoinPoint pjp) {
        System.out.println("[AOP Aronud before]...");
        Object obj = null;
        try {
            obj = pjp.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("[AOP Aronud after]...");
        return obj;
    }
}
