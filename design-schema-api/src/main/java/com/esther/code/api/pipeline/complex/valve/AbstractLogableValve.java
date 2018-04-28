package com.esther.code.api.pipeline.complex.valve;

import com.esther.code.api.logger.LoggerWrapper;
import com.esther.code.api.logger.LoggerWrapperAware;

/**
 * Created by jiyanbin on 15/7/17.
 *
 * 具有日志对像感知能力的抽像阀门
 */
public abstract class AbstractLogableValve<Context, E extends Exception> implements Valve<Context, E>, LoggerWrapperAware {
    protected LoggerWrapper logger;

    @Override
    public void setLogger(LoggerWrapper logger) {
        this.logger = logger;
    }
}
