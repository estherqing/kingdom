package com.esther.code.pipeline.valve;

/**
 * Author: jiyanbin@zafh.com.cn
 * Date: 2015-11-6
 * JDK: 1.8
 */

/**
 * 阀门
 * <p/>
 * <p/>
 * 标记接口
 *
 * @author jiyanbin
 * @version 1.00 Aug 22, 2003 11:52:44 PM
 */
public interface Valve<Context, E extends Exception> {
    /**
     * 阀门处理接口。根据context中的信息，进行处理。ValveChain用于控制
     * 是否需要执行下一个阀门.
     *
     * @param context 阀门上下文
     * @param chain   阀门控制链,控制是否需要继续执行管道中的阀门.
     */
    public void handle(Context context, ValveChain<Context, E> chain)
            throws E;
}
