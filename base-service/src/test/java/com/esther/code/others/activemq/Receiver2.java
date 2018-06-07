package com.esther.code.others.activemq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author esther
 * 2018-06-04 10:53
 * 1.在E:\apache-activemq-5.15.4\bin\win64目录下，启动activemq.bat
 * 2.访问http://localhost:8161/admin，用户名和密码为admin admin
 * 3.运行Receiver.java文件
 * 4.运行Sender.java文件
 * 5.在浏览器中查看activemq的运行情况
 */

public class Receiver2 {
    public static void main(String[] args) {
        // ConnectionFactory ：连接工厂，JMS 用它创建连接
        ConnectionFactory connectionFactory;
        // Connection ：JMS 客户端到JMS Provider 的连接
        Connection connection = null;
        // Session： 一个发送或接收消息的线程
        Session session;
        // Destination ：消息的目的地;消息发送给谁.
        Destination destination;
        // 消费者，消息接收者
        MessageConsumer consumer;
        connectionFactory = new ActiveMQConnectionFactory(
                ActiveMQConnection.DEFAULT_USER,
                ActiveMQConnection.DEFAULT_PASSWORD, "tcp://localhost:61616");
        try {
            // 构造从工厂得到连接对象
            connection = connectionFactory.createConnection();
            connection.setClientID("esther-888");
            // 获取操作连接
            session = connection.createSession(Boolean.FALSE,
                    Session.AUTO_ACKNOWLEDGE);
            // 获取session注意参数值FirstQueue是一个服务器的queue，须在在ActiveMq的console配置
//            destination = session.createQueue("FirstQueue");
            destination=session.createTopic("FirstTopic");
//            consumer = session.createConsumer(destination);
            consumer=session.createDurableSubscriber((Topic) destination,"t2");
            // 启动
            connection.start();
            System.out.println("Consumer2:->Begin listening...");

            while (true) {
                // 设置接收者接收消息的时间，为了便于测试，这里设定为100s
                TextMessage message = (TextMessage) consumer.receive(100000);
                if (null != message) {
                    System.out.println("Receiver2收到消息：" + message.getText());
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != connection)
                    connection.close();
            } catch (Throwable ignore) {
            }
        }
    }
}
