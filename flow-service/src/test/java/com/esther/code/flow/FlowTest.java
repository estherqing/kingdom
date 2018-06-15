package com.esther.code.flow;

import com.esther.code.BaseJunit4Test;
import com.esther.code.api.IBusinessObjectProcessInfoService;
import com.esther.code.model.BusinessObjectProcessInfo;
import com.esther.code.model.SubmitParam;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @author esther
 * 2018-05-02 11:51
 * $DESCRIPTION}
 */

public class FlowTest extends BaseJunit4Test {
    @Autowired
    @Qualifier("P1LaunchActionImpl")
    private IBaseProcessAction<Exception> baseProcessAction;

    @Autowired
    @Qualifier("defaultBOProcessInfoService")
    private IBusinessObjectProcessInfoService boProcessInfoService;

    @Test
    public void test() throws Exception {
        BusinessObjectProcessInfo businessObjectProcessInfo = boProcessInfoService.fetchBusinessObjectProcessInfo(1L);
        SubmitParam submitParam = baseProcessAction.submit2NextNode(2, "rose", businessObjectProcessInfo);
        System.out.println(submitParam);
    }

}
