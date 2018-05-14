package com.esther.code.api.schema.service.observer.ordinary;

import com.esther.code.api.schema.observer.ordinary.Observer;

/**
 * 观察者
 */
public class Alarm implements Observer {
    private String observerState;       //定义观察者的状态
    @Override
    public void update(String state) {
        Boolean flag = Boolean.parseBoolean(state);
        if(flag){
            System.out.println("报警器响了，水温超过100度了。");
        }
    }

}