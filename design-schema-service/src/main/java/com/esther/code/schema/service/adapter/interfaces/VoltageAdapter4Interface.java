package com.esther.code.schema.service.adapter.interfaces;

import com.esther.code.schema.api.adapter.IVoltage220;
import com.esther.code.schema.api.adapter.IVoltage5;

/**
 * @author esther
 * 2018-05-04 10:57
 * 缺省适配器模式：
当不需要全部实现接口提供的方法时，可先设计一个抽象类实现接口，并为该接口中每个方法提供一个默认实现（空方法），
那么该抽象类的子类可有选择地覆盖父类的某些方法来实现需求，它适用于一个接口不想使用其所有的方法的情况。
 */

public class VoltageAdapter4Interface implements IVoltage220, IVoltage5 {
    @Override
    public int output220V() {
        int src = 220;
        System.out.println("我是" + src + "V");
        return src;
    }

    @Override
    public int output5V() {
        int src = output220V();
        System.out.println("适配器工作开始适配电压");
        int dst = src / 44;
        System.out.println("适配完成后输出电压：" + dst);
        return dst;
    }
}
