package com.esther.code.flow;

import com.esther.code.model.BusinessObjectProcessInfo;

/**
 * Author: jiyanbin@zafh.com.cn
 * JDK: 1.8
 * Created on 15/12/1.
 * 可关闭流程动作接口
 */
public interface CloseableProcessAction<E extends Exception> {

    /**
     * 关闭流程
     * <p>
     *
     * @param currentBOProcessInfo
     * @param <R>
     * @return
     * @throws <E>
     */
    <R> R close(BusinessObjectProcessInfo currentBOProcessInfo) throws E;
}
