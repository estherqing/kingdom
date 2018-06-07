package com.esther.code.tools.mq.activemq.spring;

import org.springframework.stereotype.Component;

/**
 * @author esther
 * 2018-06-04 19:26
 * 声明一个POJO来异步接收消息
 */
@Component("activeMQObjectHandler")
public class ActiveMQObjectHandler {

    public void handle(Object o) {
        System.out.println("ActiveMQObjectHandler：异步接收对象：" + o);
    }

}
