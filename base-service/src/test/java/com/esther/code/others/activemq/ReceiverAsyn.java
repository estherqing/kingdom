package com.esther.code.others.activemq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author esther
 * 2018-06-04 16:01
 * $DESCRIPTION}
 */

public class ReceiverAsyn {
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

    public void receive() {

        try {
            connectionFactory = new ActiveMQConnectionFactory(
                    ActiveMQConnection.DEFAULT_USER,
                    ActiveMQConnection.DEFAULT_PASSWORD, "tcp://localhost:61616");

            // 构造从工厂得到连接对象
            connection = connectionFactory.createConnection();
            // 启动
            // 获取操作连接
            session = connection.createSession(Boolean.FALSE,
                    Session.AUTO_ACKNOWLEDGE);
            // 获取session注意参数值FirstQueue是一个服务器的queue，须在在ActiveMq的console配置
//            destination = session.createQueue("FirstQueue");
            destination=session.createTopic("FirstTopic");
            consumer = session.createConsumer(destination);
            connection.start();
            System.out.println("Consumer异步:->Begin listening...");
            // 开始监听
            consumer.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message arg0) {
                    try {
                        if (arg0 instanceof TextMessage) {
                            TextMessage txtMsg = (TextMessage) arg0;
                            System.out.println("consumer异步 recive:" + txtMsg.getText());
                            Thread.sleep(500);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });  //(异步接收)

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 关闭连接
    public void close() throws JMSException {
        System.out.println("Consumer:->Closing connection");
        if (consumer != null)
            consumer.close();
        if (session != null)
            session.close();
        if (connection != null)
            connection.close();
    }
}
