package com.esther.code.schema.service.pipeline.complex.flow;

import com.esther.code.flow.AbstractProcessFlowAction;
import com.esther.code.model.User;
import org.springframework.stereotype.Service;

/**
 * @author esther
 * 2018-04-27 17:52
 * $DESCRIPTION}
 */
@Service("processFlowAction")
public class ProcessFlowAction extends AbstractProcessFlowAction<Exception> {

    @Override
    public void submit(User user, boolean isOk) throws Exception {
        user.setAge(18);
        super.submit(user, isOk);
    }
}
