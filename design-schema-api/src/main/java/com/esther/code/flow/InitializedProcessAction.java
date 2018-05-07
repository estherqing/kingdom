package com.esther.code.flow;


import com.esther.code.model.BusinessObjectProcessInfo;

/**
 * Author: jiyanbin@zafh.com.cn
 * JDK: 1.8
 * Created on 15/12/1.
 * 可初始化业务流程接口
 */
public interface InitializedProcessAction<E extends Exception> {

    /**
     * 保存业务对象的修改
     * <p>
     *
     * @param <R> return type
     * @return
     * @throws E 业务异常
     */
    <R> R init(BusinessObjectProcessInfo currentBOProcessInfo) throws E;
}
