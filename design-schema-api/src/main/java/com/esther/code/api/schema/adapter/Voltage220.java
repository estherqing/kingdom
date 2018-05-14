package com.esther.code.api.schema.adapter;

/**
 * @author esther
 * 2018-05-04 10:52
 * 介绍：src类: 我们有的220V电压
 */

public class Voltage220 {
    public int output220V() {
        int src = 220;
        System.out.println("我是" + src + "V");
        return src;
    }
}
