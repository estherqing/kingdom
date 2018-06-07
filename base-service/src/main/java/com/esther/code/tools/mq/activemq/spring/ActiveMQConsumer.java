package com.esther.code.tools.mq.activemq.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

/**
 * @author esther
 * 2018-06-04 18:24
 * 消费者
 */
@Service("activeMQConsumer")
public class ActiveMQConsumer {
    private JmsTemplate jmsTemplate;

    public JmsTemplate getJmsTemplate() {
        return jmsTemplate;
    }

    @Autowired
    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void receiveMessage() throws JMSException {
        /*Object message = this.jmsTemplate.receiveAndConvert();
        if (message instanceof String) {
            System.out.println("消费者：" + message);
        }*/
        // 当调用JmsTemplate的receive()方法时，JmsTemplate会尝试从ActiveMQ中获取一个消息。
        // 如果没有可用的消息，receive()方法会一直等待，直到获得消息为止。也就是说该方法时同步的。
        // 这意味着接收者必须耐心等待消息的到来，因此receive()方法会一直被阻塞，直到有可用消息（或者消息超时）。
        Message message1 = this.jmsTemplate.receive();
        if (message1 instanceof TextMessage) {
            System.out.println("进入消费者程序ActiveMQConsumer：" + ((TextMessage) message1).getText());
        }
    }
}
