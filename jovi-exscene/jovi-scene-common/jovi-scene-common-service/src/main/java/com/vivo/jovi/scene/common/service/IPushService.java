package com.vivo.jovi.scene.common.service;

/**
 * @Description
 * @Author Hu Han
 * @Date 2019-03-02 11:14
 */
public interface IPushService {

    /**
     * 批量推送
     * @param imeis    用户imei, 逗号分隔
     * @param pushMsg 推送信息
     */
    <T>void batchPush(String imeis, T pushMsg);

    /**
     * 推送
     * @param imei    用户imei
     * @param pushMsg 推送信息
     */
    void push(String imei, String pushMsg);

}
