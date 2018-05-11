package com.esther.code.schema.service.observer;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;

/**
 * @author esther
 * 2018-05-11 14:34
 * $DESCRIPTION}
 */

public class MyPubisher implements ApplicationContextAware {

    private ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }
    public void publishEvent(ApplicationEvent event){
        System.out.println("into My Publisher's method");
        applicationContext.publishEvent(event);
    }
}