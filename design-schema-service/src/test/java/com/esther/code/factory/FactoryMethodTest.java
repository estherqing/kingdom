package com.esther.code.factory;

import com.esther.code.api.factory.factoryMethod.IFoodFactory;
import com.esther.code.service.factory.factoryMethod.NoodleFactory;
import com.esther.code.service.factory.factoryMethod.RiceFactory;

/**
 * @author esther
 * 2018-05-07 11:28
 * $DESCRIPTION}
 */

public class FactoryMethodTest {
    public static void main(String[] args) {
        IFoodFactory foodFactory=new NoodleFactory();
        foodFactory.produceFood().getFood();

        foodFactory=new RiceFactory();
        foodFactory.produceFood().getFood();
    }
}
