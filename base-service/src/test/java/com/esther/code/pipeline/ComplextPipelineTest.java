package com.esther.code.pipeline;


import com.esther.code.base.BaseService;
import com.esther.code.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author esther
 * 2018-04-28 9:46
 * $DESCRIPTION}
 */

public class ComplextPipelineTest extends BaseService {
    @Autowired
    private ProcessFlowAction processFlowAction;

    @Test
    public void testPipeline() throws Exception {
        User user = new User();
        user.setUserName("esther");
        user.setPassword("123456");
        user.setUserRealName("esther");
        boolean isOk = true;
        processFlowAction.submit(user, isOk);
        System.out.println(user);
    }
}
