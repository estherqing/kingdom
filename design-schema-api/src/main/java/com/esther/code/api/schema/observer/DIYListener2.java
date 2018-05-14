package com.esther.code.api.schema.observer;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author esther
 * 2018-05-09 14:59
 * $DESCRIPTION}
 */
@Component
public class DIYListener2 implements ApplicationListener<DIYEvent> {
    @Override
    public void onApplicationEvent(DIYEvent diyEvent) {
        System.out.println("自定义监听器执行...DIYListener2");
        System.out.println(diyEvent.getSource()+"2");
    }
}
