package com.esther.code.api.pipeline.simple;

/**
 * @author esther
 * @create 2017-09-28 19:19
 * $DESCRIPTION}
 */

public interface StandardPipeline {
    public StandardValve getFirst();
    public StandardValve getBasic();
    public void setBasic(StandardValve valve);
    public void addValve(StandardValve valve);
}