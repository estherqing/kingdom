package com.esther.code.web.context;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author esther
 * 2018-05-21 16:05
 * $DESCRIPTION}
 */

public class MyHttpSessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("------------------------------HttpSession创建了：" + httpSessionEvent.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("------------------------------HttpSession销毁了：" + httpSessionEvent.getSession().getId());
    }
}
