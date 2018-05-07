package com.esther.code.service.pipeline.simple;


import com.esther.code.api.pipeline.simple.StandardValve;

/**
 * @author esther
 * @create 2017-09-28 19:20
 * $DESCRIPTION}
 */

public class BasicValve implements StandardValve {
    protected StandardValve next = null;

    public StandardValve getNext() {
        return next;
    }

    public void invoke(String handling) {
        handling = handling.replaceAll("aa", "bb");
        System.out.println("基础阀门处理完后：" + handling);
    }

    public void setNext(StandardValve valve) {
        this.next = valve;
    }
}