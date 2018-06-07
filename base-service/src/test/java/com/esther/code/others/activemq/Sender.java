package com.esther.code.others.activemq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author esther
 * 2018-06-04 10:53
 * $DESCRIPTION}
 */

public class Sender {
    private static final int SEND_NUMBER = 5;

    public static void main(String[] args) {
        // ConnectionFactory ：连接工厂，JMS 用它创建连接
        ConnectionFactory connectionFactory;
        // Connection ：JMS 客户端到JMS Provider 的连接
        Connection connection = null;
        // Session： 一个发送或接收消息的线程，单线程，支持事务
        Session session;
        // Destination ：消息目标，消息发送和接受的地点，在PTP模式下是queue，在Pub/Sub模式下是topic
        Destination destination;
        // MessageProducer：消息发送者
        MessageProducer producer;
        // 构造ConnectionFactory实例对象，此处采用ActiveMq的实现jar
        connectionFactory = new ActiveMQConnectionFactory(
                ActiveMQConnection.DEFAULT_USER,
                ActiveMQConnection.DEFAULT_PASSWORD, "tcp://localhost:61616");
        try {
            // 构造从工厂得到连接对象，注意连接默认是关闭的，因此需要start开启
            connection = connectionFactory.createConnection();

            // 获取session
            session = connection.createSession(Boolean.TRUE,
                    Session.AUTO_ACKNOWLEDGE);
            // 获取destination,注意参数值FirstQueue是一个服务器的queue，须在在ActiveMq的console配置
            //destination = session.createQueue("FirstQueue");
            destination=session.createTopic("FirstTopic");
            // 得到消息生成者【发送者】
            producer = session.createProducer(destination);
            // 设置不持久化，此处学习，实际根据项目决定
            producer.setDeliveryMode(DeliveryMode.PERSISTENT);

            // 设置持久化之后，再启动连接
            connection.start();

            // 构造消息，此处写死，项目就是参数，或者方法获取
            sendMessage(session, producer);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != connection)
                    // 关闭连接，实际上会级联的关闭其他对象，如session。对我们来说透明，不用管
                    connection.close();
            } catch (Throwable ignore) {
            }
        }
    }

    public static void sendMessage(Session session, MessageProducer producer)
            throws Exception {
        for (int i = 1; i <= SEND_NUMBER; i++) {
            // TextMessage message
            TextMessage message = session.createTextMessage("ActiveMq 发送的消息" + i);

            // 发送消息到目的地方
            System.out.println("发送消息：" + "ActiveMq 发送的消息" + i);
            producer.send(message);
        }
    }
}
