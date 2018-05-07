package com.esther.code.service.factory;

import com.esther.code.api.factory.IFood;

/**
 * @author esther
 * 2018-05-07 11:19
 * $DESCRIPTION}
 */

public class Rice implements IFood {
    @Override
    public void getFood() {
        System.out.println("获取食物：米饭。");
    }
}
