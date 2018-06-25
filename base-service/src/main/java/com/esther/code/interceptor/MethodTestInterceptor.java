package com.esther.code.interceptor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author esther
 * 2018-06-07 20:10
 * $DESCRIPTION}
 */
@Aspect
@Component
@Order(1)
public class MethodTestInterceptor {

    @Pointcut("execution(* com.esther.code.service.impl..*.*(..))")
    public void pointCut(){}


    @Before("execution(* com.esther.code.service.impl.UserServiceImpl.selectByPrimaryKey(..))")
    public void before() {
        System.out.println("方法调用前！");
    }

    @Before("pointCut()")
    public void doBefore(){
        System.out.println("before 方法调用前.......................");
    }

    @AfterThrowing(pointcut = "pointCut()",throwing = "throwable")
    public void afterThrowing(Throwable throwable){
        System.out.println("AOP afterthrowing:"+throwable);
    }

    @After("pointCut()")
    public void doAfter(JoinPoint joinPoint){
        System.out.println("AOP After Advice...");
    }

    @AfterReturning(pointcut="pointCut()",returning="returnVal")
    public void afterReturn(JoinPoint joinPoint,Object returnVal){
        System.out.println("AOP AfterReturning Advice:" + returnVal);
    }


  /*  @Around("pointCut()")
    public void around(ProceedingJoinPoint pjp){
        System.out.println("AOP Aronud before...");
        try {
            pjp.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("AOP Aronud after...");
    }*/
}
