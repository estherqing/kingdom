package com.esther.code.service.factory;

import com.esther.code.api.factory.IDrink;

/**
 * @author esther
 * 2018-05-07 11:21
 * $DESCRIPTION}
 */

public class Cocacola implements IDrink {
    @Override
    public void getDrink() {
        System.out.println("获取饮料：可口可乐。");
    }
}
