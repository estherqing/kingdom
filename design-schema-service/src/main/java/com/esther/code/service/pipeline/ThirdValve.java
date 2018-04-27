package com.esther.code.service.pipeline;


import com.esther.code.api.pipeline.Valve;

/**
 * @author esther
 * @create 2017-09-28 19:21
 * $DESCRIPTION}
 */

public class ThirdValve implements Valve {
    protected Valve next = null;
    public Valve getNext() {
        return next;
    }
    public void invoke(String handling) {
        handling = handling.replaceAll("zz", "yy");
        System.out.println("Third阀门处理完后：" + handling);
        getNext().invoke(handling);
    }
    public void setNext(Valve valve) {
        this.next = valve;
    }
}
