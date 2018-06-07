package com.esther.code.others.activemq;


import com.esther.code.model.User;
import com.esther.code.BaseJunit4Test;
import com.esther.code.tools.mq.activemq.spring.ActiveMQConsumer;
import com.esther.code.tools.mq.activemq.spring.ActiveMQProducer;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.JMSException;

public class SpringActiveMQTest extends BaseJunit4Test {

    @Autowired
    private ActiveMQProducer activeMQProducer;

    @Autowired
    private ActiveMQConsumer activeMQConsumer;

    @Test
    public void sendMessage() throws JMSException {
        this.activeMQProducer.sendMessage("the message come from Spring!");
        this.activeMQProducer.sendMessage("hello world!");
        this.activeMQProducer.sendMessage("你好!");
        System.out.println(activeMQConsumer);
        activeMQConsumer.receiveMessage();
    }

    @Test
    public void send() throws JMSException {
        User user=new User(1,"rose");
        this.activeMQProducer.sendObject(user);
    }

}
