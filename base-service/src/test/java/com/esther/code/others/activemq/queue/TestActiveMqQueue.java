package com.esther.code.others.activemq.queue;

import javax.jms.JMSException;

/**
 * @author esther
 * 2018-06-04 15:35
 * $DESCRIPTION}
 */

public class TestActiveMqQueue {
    public static void main(String[] args) throws InterruptedException, JMSException {
        ActivemqQueueProducer producer = new ActivemqQueueProducer();
        ActivemqQueueConsumer consumer = new ActivemqQueueConsumer("1");
        ActivemqQueueConsumerAsyn consumer1 = new ActivemqQueueConsumerAsyn("2");
        producer.initialize();


        Thread.sleep(500);
        for (int i = 0; i < 5; i++) {
            producer.sendText("Hello, world!" + i);
        }

        //producer.submit();//如果开启事务需使用
        // producer.close();
        System.out.println("consumer1开始监听");
        consumer.recive();
        consumer.close();
        System.out.println("consumer1接收完毕！");


        for (int i = 0; i < 5; i++) {
            // producer.sendText("Hello, world!" + i);
            producer.sendMap("jack" + i, 18 + i);
        }
        //  producer.submit();//如果开启事务需使用
        System.out.println("consumer2开始监听");
        consumer1.recive();
        // 异步接受不能关闭close，否则接受不到消息
        System.out.println("consumer2接收完毕！");


    }
}
