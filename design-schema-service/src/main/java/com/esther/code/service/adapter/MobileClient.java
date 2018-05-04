package com.esther.code.service.adapter;

import com.esther.code.api.adapter.IVoltage5;

/**
 * @author esther
 * 2018-05-04 11:00
 * 介绍：Client类：手机 .需要5V电压
 */

public class MobileClient {
    /**
     * 充电方法
     *
     * @param IVoltage5
     */
    public void charging(IVoltage5 IVoltage5) {
        if (IVoltage5.output5V() == 5) {
            System.out.println("电压刚刚好5V，开始充电");
        } else if (IVoltage5.output5V() > 5) {
            System.out.println("电压超过5V，都闪开 我要变成note7了");
        }
    }
}
