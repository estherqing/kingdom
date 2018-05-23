package com.esther.code.schema.api.chain;

/**
 * @author esther
 * 2018-05-23 17:50
 * $DESCRIPTION}
 */

public abstract class AbstractHandler {

    private AbstractHandler handler;

    public abstract void handleRequest(String condition);

    public AbstractHandler getHandler() {
        return handler;
    }

    public void setHandler(AbstractHandler handler) {
        this.handler = handler;
    }
}
