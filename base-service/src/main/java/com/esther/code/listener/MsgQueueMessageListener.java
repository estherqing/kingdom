package com.esther.code.listener;

import org.springframework.jms.listener.SessionAwareMessageListener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * 消费者实现监听器
 */
public class MsgQueueMessageListener implements SessionAwareMessageListener<Message> {

    @Override
    public void onMessage(Message message, Session session) throws JMSException {
        if(message instanceof TextMessage){
            System.out.println("进入MsgQueueMessageListener：异步监听器: " + ((TextMessage) message).getText());
        }
    }

}
