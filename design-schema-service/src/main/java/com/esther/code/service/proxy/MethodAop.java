package com.esther.code.service.proxy;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author esther
 * 2018-04-25 16:58
 * $DESCRIPTION}
 */
@Aspect
@Component
public class MethodAop {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* *.*(..))")
    public void before() {
        logger.info("方法调用前！");
    }

    @After("execution(* com.esther.code.service.proxy..*(..))")
    public void after() {
        logger.info("方法调用后！");
    }
}
