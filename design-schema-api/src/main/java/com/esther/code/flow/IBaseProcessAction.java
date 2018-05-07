package com.esther.code.flow;


import com.esther.code.model.BusinessObjectProcessInfo;
import com.esther.code.model.FlowNode;
import com.esther.code.model.SubmitParam;

/**
 * Author: jiyanbin@zafh.com.cn
 * JDK: 1.8
 * Created on 15/11/9.
 * <p>
 * <p>
 * 业务对象基础流程动作接口
 * <p>
 * 所有业务对象流程通用的的公共动作都在此接口中抽像
 *
 * @param <E>
 */

public interface IBaseProcessAction<E extends Exception> extends CancelableProcessAction<E>,
        InitializedProcessAction<E> {

    /**
     * 获取流程下一节点
     *
     * @param currentBOProcessInfo
     * @return
     */
    FlowNode getNextFlowNode(BusinessObjectProcessInfo currentBOProcessInfo);
    /**
     * 预提交
     *
     * @return
     * @throws E
     */
    SubmitParam preSubmit(BusinessObjectProcessInfo currentBOProcessInfo) throws E;

    /**
     * 提交至下一节点处理人
     *
     * @param nextNodeUserId   下一节点处理人ID
     * @param nextNodeUserName 下一节点处理人名称
     *                         //@param currentBOProcessInfo 当前业务对象所正在处于的流程信息
     * @return
     * @throws E
     */
    SubmitParam submit2NextNode(int nextNodeUserId, String nextNodeUserName, BusinessObjectProcessInfo currentBOProcessInfo) throws E;



    /**
     * 回退至上一节点
     *
     * @return
     * @throws E
     */
    SubmitParam back2PreNode(BusinessObjectProcessInfo currentBOProcessInfo) throws E;
}
