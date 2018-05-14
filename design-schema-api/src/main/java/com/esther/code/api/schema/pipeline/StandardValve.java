package com.esther.code.api.schema.pipeline;

/**
 * @author esther
 * @create 2017-09-28 19:18
 * $DESCRIPTION}
 */

public interface StandardValve {
    public StandardValve getNext();
    public void setNext(StandardValve valve);
    public void invoke(String handling);
}
