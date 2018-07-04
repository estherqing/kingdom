package com.esther.code.web.context.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * @author esther
 * 2018-05-21 16:03
 * $DESCRIPTION}
 */

public class MyServletRequestListener implements ServletRequestListener {
    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        System.out.println("---------------------------------ServletRequestListener启动了。。。request请求时执行----------------------");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        System.out.println("--------------------------------ServletRequestListener停止了。。。响应完毕后执行对应的销毁方法------------------");
    }
}
