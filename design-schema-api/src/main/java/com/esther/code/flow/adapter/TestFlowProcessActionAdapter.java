package com.esther.code.flow.adapter;


import com.esther.code.base.exception.I18NSupportException;
import com.esther.code.model.BusinessObjectProcessInfo;
import com.esther.code.model.SubmitParam;
import com.esther.code.model.User;


/**
 * Author: jiyanbin@zafh.com.cn
 * JDK: 1.8
 * Created on 15/11/15.
 *
 * 贷款流程动作适配器
 * <p/>
 * 此接口为粗粒度动作适配接口
 */
public interface TestFlowProcessActionAdapter extends ActionAdapter {
    /**
     * 关闭一贷款项目
     * @param info
     * @param <R>
     * @return
     * @throws I18NSupportException
     */
    <R> R close(User user, BusinessObjectProcessInfo info) throws I18NSupportException;



    /**
     * 回退
     * @param info
     * @return
     * @throws I18NSupportException
     */
    SubmitParam back2Launch(User user, BusinessObjectProcessInfo info) throws I18NSupportException;




    /**
     * 根据nodeKey提交下个节点
     * <p>
     * @param info
     * @param nextNodeUserId
     * @param nextNodeUserName
     * @return
     * @throws I18NSupportException
     */
    SubmitParam submit2NextByNodeKey(User user, BusinessObjectProcessInfo info, int nextNodeUserId, String nextNodeUserName, String nodeKey) throws I18NSupportException;

}
