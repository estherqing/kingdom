package com.esther.code.observer;

import com.esther.code.api.schema.observer.DIYEvent;
import com.esther.code.api.schema.service.observer.MyPubisher;
import com.esther.code.api.schema.service.observer.ordinary.Alarm;
import com.esther.code.api.schema.service.observer.ordinary.Display;
import com.esther.code.api.schema.service.observer.ordinary.Heater;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author esther
 * 2018-05-09 15:01
 * $DESCRIPTION}
 */

public class DIYTest{
   // private ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:/spring/applicationContext.xml");

    @Test
    public void diyTest(){
         ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:/spring/applicationContext.xml");

        applicationContext.publishEvent(new DIYEvent("测试数据"));
        MyPubisher pubisher=new MyPubisher();
        pubisher.setApplicationContext(applicationContext);
        pubisher.publishEvent(new DIYEvent("自定义发布的测试数据"));
    }

    @Test
    public void testOrdinary(){
        Heater heater = new Heater();
        Display display = new Display();
        Alarm alarm = new Alarm();
        heater.registerObserver(display);
        display.registerObserver(alarm);
        heater.boilWater();
    }
}
