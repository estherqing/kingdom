package com.esther.code.web.context.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import java.text.MessageFormat;

/**
 * @author esther
 * 2018-05-21 15:51
 * $DESCRIPTION}
 */

public class MyServletRequestAttributeListener implements ServletRequestAttributeListener {
    @Override
    public void attributeAdded(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        System.out.println(MessageFormat.format("ServletRequest域对象中添加了属性:{0}，属性值是:{1}",
                servletRequestAttributeEvent.getName(), servletRequestAttributeEvent.getValue()));
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        System.out.println(MessageFormat.format("ServletRequest域对象中删除了属性:{0}，属性值是:{1}",
                servletRequestAttributeEvent.getName(), servletRequestAttributeEvent.getValue()));
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        System.out.println(MessageFormat.format("ServletRequest域对象中替换了属性:{0}，属性值是:{1}",
                servletRequestAttributeEvent.getName(), servletRequestAttributeEvent.getValue()));
    }
}
