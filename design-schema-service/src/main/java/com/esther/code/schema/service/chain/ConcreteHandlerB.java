package com.esther.code.schema.service.chain;

import com.esther.code.schema.api.chain.AbstractHandler;

/**
 * @author esther
 * 2018-05-23 17:51
 * $DESCRIPTION}
 */

public class ConcreteHandlerB extends AbstractHandler {

    @Override
    public void handleRequest(String condition) {
        if (condition.equals("B")) {
            System.out.println("ConcreteHandlerB处理");
        } else {
            System.out.println("ConcreteHandlerB不处理，由其他的Handler处理");
            super.getHandler().handleRequest(condition);
        }
    }
}
