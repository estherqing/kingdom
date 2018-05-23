package com.esther.code.schema.api.adapter.springmvc;

/**
 * @author esther
 * 2018-05-04 14:13
 * 定义一个Adapter接口
 */

public interface HandlerAdapter {
    public boolean supports(Object handler);
    public void handle(Object handler);
}
