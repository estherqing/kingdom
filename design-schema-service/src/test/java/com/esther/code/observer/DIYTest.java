package com.esther.code.observer;

import com.esther.code.schema.api.observer.DIYEvent;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author esther
 * 2018-05-09 15:01
 * $DESCRIPTION}
 */

public class DIYTest{
    private ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:/spring/applicationContext.xml");

    @Test
    public void diyTest(){
        applicationContext.publishEvent(new DIYEvent("测试数据"));
    }
}
