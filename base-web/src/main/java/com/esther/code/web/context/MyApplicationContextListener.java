package com.esther.code.web.context;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.ContextLoader;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author esther
 * 2018-05-21 14:12
 * $DESCRIPTION}
 */

public class MyApplicationContextListener implements ServletContextListener {
    private static final Log logger = LogFactory.getLog(ContextLoader.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        logger.info("应用启动了。。。。。");
        System.out.println("应用启动了。。。。。");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        logger.info("应用停止了。。。。。");
        System.out.println("应用停止了。。。。。");
    }
}
