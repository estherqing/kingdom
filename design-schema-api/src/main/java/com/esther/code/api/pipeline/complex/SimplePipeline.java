package com.esther.code.api.pipeline.complex;

import com.esther.code.api.pipeline.complex.valve.SimpleValveChain;
import com.esther.code.api.pipeline.complex.valve.Valve;
import com.esther.code.api.pipeline.complex.valve.ValveChain;

/**
 * Author: jiyanbin@zafh.com.cn
 * Date: 2015-11-6
 * JDK: 1.8
 */
public class SimplePipeline<Context, E extends Exception> extends BasePipeline<Valve<Context, E>> implements Pipeline<Context, E> {

    /**
     * 管道处理。
     *
     * @param context 阀门上下文.
     */
    @Override
    public void handle(Context context)
            throws E {
        ValveChain<Context, E> chain = new SimpleValveChain<Context, E>(getValves());
        chain.handleNext(context);
    }

    @Override
    public void handle(Context context, ValveChain<Context, E> chain) throws E {
        handle(context);
        chain.handleNext(context);
    }
}
