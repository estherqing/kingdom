package com.esther.code.service.pipeline.simple;


import com.esther.code.api.pipeline.simple.StandardValve;

/**
 * @author esther
 * @create 2017-09-28 19:21
 * $DESCRIPTION}
 */

public class SecondValve implements StandardValve {
    protected StandardValve next = null;
    public StandardValve getNext() {
        return next;
    }
    public void invoke(String handling) {
        handling = handling.replaceAll("11", "22");
        System.out.println("Second阀门处理完后：" + handling);
        getNext().invoke(handling);
    }
    public void setNext(StandardValve valve) {
        this.next = valve;
    }
}