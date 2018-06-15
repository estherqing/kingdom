package com.esther.code.pipeline;


import com.esther.code.pipeline.valve.Valve;

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
