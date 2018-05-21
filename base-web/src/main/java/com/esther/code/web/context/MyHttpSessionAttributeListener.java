package com.esther.code.web.context;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.text.MessageFormat;

/**
 * @author esther
 * 2018-05-21 15:53
 * $DESCRIPTION}
 */

public class MyHttpSessionAttributeListener implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println(MessageFormat.format("HttpSession域对象中添加了属性:{0}，属性值是:{1}",
                httpSessionBindingEvent.getName(), httpSessionBindingEvent.getValue()));
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println(MessageFormat.format("HttpSession域对象中删除了属性:{0}，属性值是:{1}",
                httpSessionBindingEvent.getName(), httpSessionBindingEvent.getValue()));
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println(MessageFormat.format("HttpSession域对象中替换了属性:{0}，属性值是:{1}",
                httpSessionBindingEvent.getName(), httpSessionBindingEvent.getValue()));
    }
}
