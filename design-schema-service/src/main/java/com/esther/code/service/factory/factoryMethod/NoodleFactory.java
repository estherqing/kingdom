package com.esther.code.service.factory.factoryMethod;

import com.esther.code.api.factory.IFood;
import com.esther.code.api.factory.factoryMethod.IFoodFactory;
import com.esther.code.service.factory.Noodle;

/**
 * @author esther
 * 2018-05-07 11:25
 * $DESCRIPTION}
 */

public class NoodleFactory implements IFoodFactory {
    @Override
    public IFood produceFood() {
        System.out.println("---面条厂---");
        return new Noodle();
    }
}
