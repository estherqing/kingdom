package com.esther.code.util;

import com.google.common.util.concurrent.AbstractIdleService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 启动dubbo服务器端服务
 */
public class DubboStart extends AbstractIdleService {
    private ClassPathXmlApplicationContext context;

    public static void main(String[] args) {
        DubboStart bootstrap = new DubboStart();
        bootstrap.startAsync();
        try {
            Object lock = new Object();
            synchronized (lock) {
                while (true) {
                    lock.wait();
                }
            }
        } catch (InterruptedException ex) {
            System.err.println("ignoreinterruption");
        }
    }

    @Override
    protected void shutDown() throws Exception {
        context.stop();
        System.out.println("-------------schema-service stoppedsuccessfully-------------");
    }

    @Override
    protected void startUp() throws Exception {
        context = new ClassPathXmlApplicationContext("classpath*:/spring/applicationContext.xml");
        context.start();
        context.registerShutdownHook();
        System.out.println("----------------schema-service provider service started successfully------------");

    }
}
