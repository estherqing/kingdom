package com.esther.code.schema.api.pipeline.complex.valve;

/**
 * Author: jiyanbin@zafh.com.cn
 * Date: 2015-11-6
 * JDK: 1.8
 */
public interface ValveChain<Context, E extends Exception> {
    public void handleNext(Context context) throws E;
}
