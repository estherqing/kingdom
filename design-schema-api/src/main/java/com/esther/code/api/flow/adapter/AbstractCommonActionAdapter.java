package com.esther.code.api.flow.adapter;

import com.esther.code.api.flow.IBaseProcessAction;
import com.esther.code.base.exception.I18NSupportException;
import com.esther.code.model.BusinessObjectProcessInfo;
import com.esther.code.model.FlowNode;
import com.esther.code.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Objects;

/**
 * Author: jiyanbin@zafh.com.cn
 * JDK: 1.8
 * Created on 16/3/29.
 */
@Transactional(rollbackFor = Exception.class)
public abstract class AbstractCommonActionAdapter< A extends IBaseProcessAction<I18NSupportException>> extends AbstractActionAdapter<A> {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public BusinessObjectProcessInfo init(User user, BusinessObjectProcessInfo currentBOProcessInfo) throws I18NSupportException {
        if (Objects.isNull(currentBOProcessInfo)) {
            BusinessObjectProcessInfo info = new BusinessObjectProcessInfo();
            FlowNode currentFlowNode = flowService.getFirstFlowNode(getBusinessType().getBusinessType());
            info.setBusinessType(getBusinessType().getBusinessType());
            info.setFlowIndex(1);
            info.setIsSubmitted(false);
            info.setIsFinished(false);
            info.setIsRead(false);
            info.setNodeIndex(currentFlowNode.getNodeIndex());
            info.setNodeKey(currentFlowNode.getNodeCode());
            info.setNodeName(currentFlowNode.getNodeName());
            info.setOperatorId(user.getId());
            info.setOperatorName(user.getUserRealName());
            info.setCreateDateTime(new Date());
            info.setApprovalResult(1);
            info.setApprovalDateTime(new Date());
            info.setLaunchUserId((long)user.getId());
            info.setLaunchUserName(user.getUserRealName());

            currentBOProcessInfo = fetchProcessAction(info).init(info);
        }
        return currentBOProcessInfo;
    }

}
