package com.esther.code.schema.service.chain;

import com.esther.code.schema.api.chain.AbstractHandler;

/**
 * @author esther
 * 2018-05-23 17:51
 * $DESCRIPTION}
 */

public class ConcreteHandlerA extends AbstractHandler {

    @Override
    public void handleRequest(String condition) {
        if (condition.equals("A")) {
            System.out.println("ConcreteHandlerA处理");
        } else {
            System.out.println("ConcreteHandlerA不处理，由其他的Handler处理");
            super.getHandler().handleRequest(condition);
        }
    }
}
