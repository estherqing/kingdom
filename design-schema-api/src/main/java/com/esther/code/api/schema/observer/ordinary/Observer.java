package com.esther.code.api.schema.observer.ordinary;

/**
 * 观察者接口
 *
 */
public interface Observer {
    /**
     * 更新接口
     * @param state 更新的状态
     */
    public void update(String state);
}