package com.esther.code.api.pipeline.complex;

import com.esther.code.api.pipeline.complex.valve.Valve;

/**
 * Author: jiyanbin@zafh.com.cn
 * Date: 2015-11-6
 * JDK: 1.8
 * <p>
 * <p/>
 * 管道接口
 */
public interface Pipeline<Context, E extends Exception> extends Valve<Context, E> {
    public void handle(Context context)
            throws E;
}
