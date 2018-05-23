package com.esther.code.schema.service.chain;

import com.esther.code.schema.api.chain.AbstractHandler;

/**
 * @author esther
 * 2018-05-23 17:51
 * $DESCRIPTION}
 */

public class ConcreteHandlerC extends AbstractHandler {

    @Override
    public void handleRequest(String condition) {
        // 一般是最后一个处理者
        System.out.println("ConcreteHandlerC处理");

    }
}
