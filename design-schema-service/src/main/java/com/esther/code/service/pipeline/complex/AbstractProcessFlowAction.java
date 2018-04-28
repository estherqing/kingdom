package com.esther.code.service.pipeline.complex;

import com.esther.code.api.logger.LoggerWrapper;
import com.esther.code.api.logger.LoggerWrapperAware;
import com.esther.code.api.pipeline.complex.Pipeline;
import com.esther.code.model.SubmitParam;
import com.esther.code.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @author esther
 * 2018-04-28 9:24
 * $DESCRIPTION}
 */

public abstract class AbstractProcessFlowAction<E extends Exception> implements LoggerWrapperAware {
    @Autowired
    @Qualifier("submitPipeline")
    protected Pipeline<SubmitParam, E> submitPipeline;

    private LoggerWrapper logger;

    @Override
    public void setLogger(LoggerWrapper logger) {
        this.logger = logger;
    }

    public void doSubmit(User user, boolean isOk) throws E {
        SubmitParam submitParam = new SubmitParam();
        submitParam.setUser(user);
        submitParam.setOk(isOk);
        getSubmitPipeline().handle(submitParam);
    }

    public Pipeline<SubmitParam, E> getSubmitPipeline() {
        return submitPipeline;
    }

    public void setSubmitPipeline(Pipeline<SubmitParam, E> submitPipeline) {
        this.submitPipeline = submitPipeline;
    }
}
