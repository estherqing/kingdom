package com.esther.code.schema.service.adapter.springmvc;

import com.esther.code.schema.api.adapter.springmvc.HandlerAdapter;
import com.esther.code.schema.service.adapter.springmvc.controller.impl.SimpleController;

/**
 * @author esther
 * 2018-05-04 14:15
 * 适配器类
 */

public class SimpleHandlerAdapter implements HandlerAdapter {
    @Override
    public boolean supports(Object handler) {
        return (handler instanceof SimpleController);
    }

    @Override
    public void handle(Object handler) {
        ((SimpleController) handler).doSimplerHandler();
    }
}
