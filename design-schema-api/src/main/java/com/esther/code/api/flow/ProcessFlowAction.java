package com.esther.code.api.flow;

import com.esther.code.model.User;
import org.springframework.stereotype.Component;

/**
 * @author esther
 * 2018-04-27 17:52
 * $DESCRIPTION}
 */
@Component("processFlowAction")
public class ProcessFlowAction extends AbstractProcessFlowAction<Exception> {

    @Override
    public void submit(User user, boolean isOk) throws Exception {
        user.setAge(18);
        super.submit(user, isOk);
    }
}
