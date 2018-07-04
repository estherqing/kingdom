package com.esther.code.web.context.listener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * @author esther
 * 2018-05-21 16:25
 * HttpSessionBindingListener监听器，专门用于监听JavaBean对应在HttpSession中的状态情况，只需要在JavaBean中对其实现即可，不需要再xml中配置.
 *
 * *实现了HttpSessionBindingListener接口的 JavaBean对象可以感知自己被绑定到 Session中和从Session中删除的事件。
 * 当对象被绑定到 HttpSession 对象中时，web 服务器调用该对象的 void valueBound(HttpSessionBindingEvent event) 方法
 * 当对象从 HttpSession 对象中解除绑定时，web 服务器调用该对象的 void valueUnbound(HttpSessionBindingEvent event)方法
 */

public class TestBindingBean implements HttpSessionBindingListener {
    private String name;

    @Override
    public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("-------------------------------" + name + "被加到session中了");
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("-------------------------------" + name + "被session踢出来了");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TestBindingBean(String name) {
        this.name = name;
    }
}
