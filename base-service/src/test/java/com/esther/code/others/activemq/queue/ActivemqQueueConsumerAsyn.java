package com.esther.code.others.activemq.queue;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author esther
 * 2018-06-04 15:34
 * $DESCRIPTION}
 */

public class ActivemqQueueConsumerAsyn {
    private String name = "";
    private Connection connection = null;
    private Session session = null;
    private MessageConsumer consumer = null;

    private String condition = "age>=20";

    public ActivemqQueueConsumerAsyn(String name) {
        this.name = name;
    }

    public void initialize() throws JMSException {
        ConnectionFactory connectFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER,
                ActiveMQConnection.DEFAULT_PASSWORD,
                "tcp://localhost:61616");
        Connection connection = connectFactory.createConnection();
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue("queue1");
        consumer = session.createConsumer(destination, condition);
        connection.start();

    }

    public void recive() {
        try {
            initialize();
            System.out.println("Consumer(" + name + "):->Begin listening...");
            // 开始监听
            consumer.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message arg0) {
                    try {
                        if (arg0 instanceof TextMessage) {
                            TextMessage txtMsg = (TextMessage) arg0;
                            System.out.println("consumer(" + name + ")异步 recive:" + txtMsg.getText());
                            Thread.sleep(500);
                        }
                        if (arg0 instanceof MapMessage) {
                            MapMessage mapMessage = (MapMessage) arg0;
                            System.out.println("consumer(" + name + ")异步 recive: name=" + mapMessage.getString("name")
                                    + ", age=" + mapMessage.getIntProperty("age"));
                            Thread.sleep(500);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });  //(异步接收)
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public void submit() throws JMSException {
        session.commit();
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
