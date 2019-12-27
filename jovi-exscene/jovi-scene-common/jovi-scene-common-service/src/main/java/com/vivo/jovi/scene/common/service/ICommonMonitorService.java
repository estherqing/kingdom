package com.vivo.jovi.scene.common.service;


import com.vivo.jovi.scene.common.model.DeviceBasicParam;

/**
 * @author WangWenqian
 * @version 1.0
 * @describe
 * @date 2018/4/15
 */
public interface ICommonMonitorService {

    /**
     * 对推送次数进行监控，有异常会返回true
     * @param imei
     * @return
     */
    boolean monitorImeiPush(String imei);

    /**
     * 对订阅号进行监控
     * @param subCode
     * @param creType
     * @param basicParam
     */
    void monitorSubCode(String subCode, Integer creType, DeviceBasicParam basicParam);
}
