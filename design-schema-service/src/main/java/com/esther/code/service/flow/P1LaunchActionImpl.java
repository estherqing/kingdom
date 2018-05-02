package com.esther.code.service.flow;

import com.esther.code.api.flow.myflow.AbstractTestProcessAction;
import com.esther.code.model.BusinessObjectProcessInfo;
import com.esther.code.model.SubmitParam;
import org.springframework.stereotype.Component;

/**
 * @author esther
 * 2018-05-02 11:06
 * $DESCRIPTION}
 */
@Component("P1LaunchActionImpl")
public class P1LaunchActionImpl extends AbstractTestProcessAction {
    @Override
    public BusinessObjectProcessInfo init(BusinessObjectProcessInfo currentBOProcessInfo) throws Exception {
        return super.init(currentBOProcessInfo);
    }

    @Override
    public SubmitParam submit2NextNode(int nextNodeUserId, String nextNodeUserName, BusinessObjectProcessInfo currentBOProcessInfo) throws Exception {
        return super.submit2NextNode(nextNodeUserId, nextNodeUserName, currentBOProcessInfo);
    }
}
