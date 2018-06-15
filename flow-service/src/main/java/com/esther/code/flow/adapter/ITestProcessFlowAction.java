package com.esther.code.flow.adapter;

import com.esther.code.exception.I18NSupportException;
import com.esther.code.flow.CloseableProcessAction;
import com.esther.code.flow.IBaseProcessAction;
import com.esther.code.logger.LoggerWrapperAware;
import com.esther.code.model.BusinessObjectProcessInfo;
import com.esther.code.model.SubmitParam;

/**
 * Author: jiyanbin@zafh.com.cn
 * JDK: 1.8
 * Created on 15/11/12.
 */
public interface ITestProcessFlowAction extends IBaseProcessAction<I18NSupportException>,
        CloseableProcessAction<I18NSupportException>, LoggerWrapperAware {

    /**
     * 退回
     *
     * @param currentBOProcessInfo
     * @return
     * @throws I18NSupportException
     */
    SubmitParam back2Launch(BusinessObjectProcessInfo currentBOProcessInfo) throws I18NSupportException;


    /**
     * 根据nodeKey提交下个节点
     *
     * @param nextNodeUserId
     * @param nextNodeUserName
     * @param currentBOProcessInfo
     * @return
     * @throws I18NSupportException
     */
    SubmitParam submit2NextByNodeKey(int nextNodeUserId, String nextNodeUserName, BusinessObjectProcessInfo currentBOProcessInfo, String nodeKey) throws I18NSupportException;

}
