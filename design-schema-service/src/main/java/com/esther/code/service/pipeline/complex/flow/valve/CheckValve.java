package com.esther.code.service.pipeline.complex.flow.valve;

import com.esther.code.api.pipeline.complex.valve.AbstractLogableValve;
import com.esther.code.api.pipeline.complex.valve.ValveChain;
import com.esther.code.model.SubmitParam;
import org.springframework.stereotype.Component;

/**
 * @author esther
 * 2018-04-27 17:53
 * $DESCRIPTION}
 */
@Component("checkValve")
public class CheckValve extends AbstractLogableValve<SubmitParam, Exception>{
    @Override
    public void handle(SubmitParam submitParam, ValveChain<SubmitParam, Exception> chain) throws Exception {
        if(!submitParam.isOk()){
            return ;
        }
        chain.handleNext(submitParam);
    }
}
