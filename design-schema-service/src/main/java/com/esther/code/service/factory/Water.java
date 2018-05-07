package com.esther.code.service.factory;

import com.esther.code.api.factory.IDrink;

/**
 * @author esther
 * 2018-05-07 11:19
 * $DESCRIPTION}
 */

public class Water implements IDrink {
    @Override
    public void getDrink() {
        System.out.println("获取饮料：水。");
    }
}
