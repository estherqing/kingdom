package com.esther.code.api.schema.service.adapter.springmvc;

import com.esther.code.api.schema.adapter.springmvc.HandlerAdapter;
import com.esther.code.api.schema.service.adapter.springmvc.controller.impl.HttpController;

/**
 * @author esther
 * 2018-05-04 14:20
 * 适配器类
 */

public class HttpHandlerAdapter implements HandlerAdapter {
    @Override
    public boolean supports(Object handler) {
        return handler instanceof HttpController;
    }

    @Override
    public void handle(Object handler) {
        ((HttpController)handler).doHttpHandler();
    }
}
