package com.esther.code.api.flow;


import com.esther.code.model.BusinessObjectProcessInfo;

/**
 * Author: jiyanbin@zafh.com.cn
 * JDK: 1.8
 * Created on 15/12/1.
 * 可取消流程动作接口
 */
public interface CancelableProcessAction<E extends Exception> {

    /**
     * 取消
     *
     * @param <R> return type
     * @return
     * @throws E
     */
    <R> R cancel(BusinessObjectProcessInfo currentBOProcessInfo) throws E;
}
