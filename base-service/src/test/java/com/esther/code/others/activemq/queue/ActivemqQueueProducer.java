package com.esther.code.others.activemq.queue;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author esther
 * 2018-06-04 15:33
 * $DESCRIPTION}
 */

public class ActivemqQueueProducer {
    private Session session;
    private MessageProducer producer;
    private Connection connection;


    public void initialize() throws JMSException {
        ConnectionFactory connectFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER,
                ActiveMQConnection.DEFAULT_PASSWORD,
                "tcp://localhost:61616");
        connection = connectFactory.createConnection();
        //session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);//支持事务
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);//不支持事务

        Destination destination = session.createQueue("queue1");
        producer = session.createProducer(destination);
        connection.start();

    }

    public void sendText(String Message) {
        try {
            TextMessage text = session.createTextMessage(Message);
            producer.send(text);
            System.out.println("Sending text message:" + text.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public void sendMap(String name, Integer age) {
        try {
            MapMessage map = session.createMapMessage();
            map.setString("name", name);
            map.setIntProperty("age", age);
            producer.send(map);
            System.out.println("Sending map message:name=" + name + ",age=" + age);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public void submit() throws JMSException {
        session.commit();
    }

    // 关闭连接
    public void close() throws JMSException {
        System.out.println("Producer:->Closing connection");
        if (producer != null)
            producer.close();
        if (session != null)
            session.close();
        if (connection != null)
            connection.close();
    }
}
