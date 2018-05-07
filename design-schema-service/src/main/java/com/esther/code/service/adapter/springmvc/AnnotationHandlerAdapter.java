package com.esther.code.service.adapter.springmvc;

import com.esther.code.api.adapter.springmvc.HandlerAdapter;
import com.esther.code.service.adapter.springmvc.controller.impl.AnnotationController;

/**
 * @author esther
 * 2018-05-04 14:21
 * 适配器类
 */

public class AnnotationHandlerAdapter implements HandlerAdapter {
    @Override
    public boolean supports(Object handler) {
        return handler instanceof AnnotationController;
    }

    @Override
    public void handle(Object handler) {
        ((AnnotationController)handler).doAnnotationHandler();
    }
}