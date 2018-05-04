package com.esther.code.adapter;

import com.esther.code.api.adapter.Voltage220;
import com.esther.code.service.adapter.MobileClient;
import com.esther.code.service.adapter.clazz.VoltageAdapter4Class;
import com.esther.code.service.adapter.interfaces.VoltageAdapter4Interface;
import com.esther.code.service.adapter.object.VoltageAdapter4Object;

/**
 * @author esther
 * 2018-05-04 11:01
类适配器，以类给到，在Adapter里，就是将src当做类，继承，
对象适配器，以对象给到，在Adapter里，将src作为一个对象，持有。
接口适配器，以接口给到，在Adapter里，将src作为一个接口，实现。
 */

public class AdapterTest {
    public static void main(String[] args) {
        MobileClient client=new MobileClient();

        System.out.println("===============类适配器==============");
        client.charging(new VoltageAdapter4Class());

        System.out.println("\n===============对象适配器==============");
        client.charging(new VoltageAdapter4Object(new Voltage220()));

        System.out.println("\n===============接口适配器==============");
        client.charging(new VoltageAdapter4Interface());

    }
}
