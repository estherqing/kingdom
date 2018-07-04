package com.esther.code;

import com.esther.code.spring.api.ILogService;
import com.esther.code.spring.model.Log;
import org.junit.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * @author esther
 * 2018-06-20 15:06
 * $DESCRIPTION}
 */

public class AOPTest {
    static ApplicationContext context = null;

    static {
        String[] xmls = {"/spring/applicationContext.xml"};
        context = new ClassPathXmlApplicationContext(xmls);
    }

    @Test
    public void aspectTest() {
        ILogService logService = context.getBean("logService", ILogService.class);
        Log log = logService.getById(1);
        System.out.println(log);
        System.out.println("isJdkDynamicProxy:" + AopUtils.isJdkDynamicProxy(logService));
        System.out.println("isCglibProxy:" + AopUtils.isCglibProxy(logService));
    }

    @Test
    public void test(){
        ILogService logService = context.getBean("logService", ILogService.class);
        logService.sayHello("esther");
    }

    @Test
    public void testExposeProxy() throws NoSuchMethodException {
        ILogService logService = context.getBean("logService", ILogService.class);
       // logService.parent("rose");
        System.out.println( logService.getClass().getMethod("parent",java.lang.String.class).getDeclaringClass());
    }

    @Test
    public void testTransaction(){
        ILogService logService = context.getBean("logService", ILogService.class);
        Log log=new Log();
        log.setMethod("test");
        log.setDescription("测试事务所用");
        log.setCreateDate(new Date());
        logService.save(log);
    }

}
