package com.esther.code.api.schema.observer;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author esther
 * 2018-05-11 11:26
 * $DESCRIPTION}
 */
@Component
public class DIYOrderdListener2 implements SmartApplicationListener {
    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> aClass) {
        return aClass==DIYEvent.class;
    }

    @Override
    public boolean supportsSourceType(Class<?> aClass) {
        return true;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if (applicationEvent instanceof DIYEvent) {
            System.out.println("自定义顺序监听器执行....DIYOrderdListener2");
            System.out.println(applicationEvent.getSource());
        }
        else{
            System.out.println("没有满足的监听器.....DIYOrderdListener2");
        }
    }

    @Override
    public int getOrder() {
        return 2;
    }
}
