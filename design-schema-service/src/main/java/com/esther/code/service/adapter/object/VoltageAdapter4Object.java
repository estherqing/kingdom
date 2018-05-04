package com.esther.code.service.adapter.object;

import com.esther.code.api.adapter.Voltage220;
import com.esther.code.api.adapter.IVoltage5;

import java.util.Objects;

/**
 * @author esther
 * 2018-05-04 10:56
 * 介绍：对象适配器模式：
 * 持有 src类，实现 dst 类接口，完成src->dst的适配。 。以达到解决兼容性的问题。
 */

public class VoltageAdapter4Object implements IVoltage5 {
    private Voltage220 voltage220;

    public VoltageAdapter4Object(Voltage220 voltage220) {
        this.voltage220 = voltage220;
    }

    @Override
    public int output5V() {
        int dst = 0;
        if (Objects.nonNull(voltage220)) {
            int src = voltage220.output220V();
            System.out.println("对象适配器工作，开始适配电压");
            dst = src / 44;
            System.out.println("适配完成后输出电压：" + dst);
        }
        return dst;
    }
}
