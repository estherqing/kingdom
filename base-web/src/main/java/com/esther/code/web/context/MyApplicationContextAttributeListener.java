package com.esther.code.web.context;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import java.text.MessageFormat;

/**
 * @author esther
 * 2018-05-21 15:19
 * $DESCRIPTION}
 */

public class MyApplicationContextAttributeListener implements ServletContextAttributeListener {
    @Override
    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println(MessageFormat.format("ServletContext域对象中添加了属性:{0}，属性值是:{1}",
                servletContextAttributeEvent.getName(), servletContextAttributeEvent.getValue()));
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println(MessageFormat.format("ServletContext域对象中删除了属性:{0}，属性值是:{1}",
                servletContextAttributeEvent.getName(), servletContextAttributeEvent.getValue()));
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println(MessageFormat.format("ServletContext域对象中替换了属性:{0}，属性值是:{1}",
                servletContextAttributeEvent.getName(), servletContextAttributeEvent.getValue()));
    }
}
