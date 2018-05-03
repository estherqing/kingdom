package com.esther.code.api.flow.adapter;


import com.esther.code.base.exception.I18NSupportException;
import com.esther.code.model.BusinessObjectProcessInfo;
import com.esther.code.model.SubmitParam;
import com.esther.code.model.User;

/**
 * Author: jiyanbin@zafh.com.cn
 * JDK: 1.8
 * Created on 15/11/15.
 * <p>
 * 流程动作适配器
 * <p>
 * 此接口为粗粒度动作适配接口
 */
public interface ActionAdapter extends Adapter {

    /**
     * 回退至上一节点
     *
     * @param info
     * @return
     * @throws  I18NSupportException
     */
    SubmitParam back2PreNode(User user, BusinessObjectProcessInfo info) throws I18NSupportException;

    /**
     * 保存
     *
     * @param currentBOProcessInfo
     * @return
     * @throws I18NSupportException
     */
    BusinessObjectProcessInfo init(User user, BusinessObjectProcessInfo currentBOProcessInfo) throws I18NSupportException;

    /**
     * 提交/预提交
     *
     * @param info
     * @return
     * @throws  I18NSupportException
     */
    SubmitParam preSubmit(User user, BusinessObjectProcessInfo info) throws I18NSupportException;

    /**
     * 确认提交至下一节点
     *
     * @param info
     * @param nextNodeUserId
     * @param nextNodeUserName
     * @return
     * @throws  I18NSupportException
     */
    SubmitParam submit2NextNode(User user, BusinessObjectProcessInfo info, int nextNodeUserId, String nextNodeUserName) throws I18NSupportException;

    /**
     * 撤销
     *
     * @param user
     * @param info
     * @return
     * @throws  I18NSupportException
     */
    <R> R cancel(User user, BusinessObjectProcessInfo info) throws I18NSupportException;
}
