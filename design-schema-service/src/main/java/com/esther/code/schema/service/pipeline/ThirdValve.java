package com.esther.code.schema.service.pipeline;


import com.esther.code.schema.api.pipeline.StandardValve;

/**
 * @author esther
 * @create 2017-09-28 19:21
 * $DESCRIPTION}
 */

public class ThirdValve implements StandardValve {
    protected StandardValve next = null;
    public StandardValve getNext() {
        return next;
    }
    public void invoke(String handling) {
        handling = handling.replaceAll("zz", "yy");
        System.out.println("Third阀门处理完后：" + handling);
        getNext().invoke(handling);
    }
    public void setNext(StandardValve valve) {
        this.next = valve;
    }
}
