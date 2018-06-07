package com.esther.code.others.activemq;

import javax.jms.JMSException;

/**
 * @author esther
 * 2018-06-04 15:53
 * $DESCRIPTION}
 */

public class TestSR {
    public static void main(String[] args) throws JMSException {
        Sender sender = new Sender();
        ReceiverAsyn receiverAsyn = new ReceiverAsyn();
        sender.main(null);
        System.out.println("consumer开始监听");
        receiverAsyn.receive();
        System.out.println("consumer接收完毕！");
    }
}
