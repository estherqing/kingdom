package com.esther.code.schema.service.proxy.dynamicProxy.jdk;

import java.lang.reflect.Method;

/**
 * @author esther
 * 2018-04-26 18:00
 * $DESCRIPTION}
 */

public class Log implements ILog{

    @Override
    public void log(Method method){
        System.out.println("调用了"+method.getName());
    }
}
