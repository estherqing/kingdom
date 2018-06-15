package com.esther.code.pipeline.valve;

import com.esther.code.model.SubmitParam;
import com.esther.code.model.User;
import org.springframework.stereotype.Component;

/**
 * @author esther
 * 2018-04-27 17:53
 * $DESCRIPTION}
 */
@Component("confirmValve")
public class ConfirmValve extends AbstractLogableValve<SubmitParam, Exception> {
    @Override
    public void handle(SubmitParam submitParam, ValveChain<SubmitParam, Exception> chain) throws Exception {
        User user=submitParam.getUser();
        user.setUserRealName(user.getUserRealName()+"-change");
        chain.handleNext(submitParam);
    }
}
