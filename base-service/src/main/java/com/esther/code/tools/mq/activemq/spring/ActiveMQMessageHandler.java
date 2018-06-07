package com.esther.code.tools.mq.activemq.spring;

/**
 * @author esther
 * 2018-06-04 19:26
 * 声明一个POJO来异步接收消息
 */
public class ActiveMQMessageHandler {

    public void handle(String info) {
        System.out.println("ActiveMQMessageHandler：异步接收消息：" + info);
    }

}
