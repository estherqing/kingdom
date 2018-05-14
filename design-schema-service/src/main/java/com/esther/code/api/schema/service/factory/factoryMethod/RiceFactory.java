package com.esther.code.api.schema.service.factory.factoryMethod;

import com.esther.code.api.schema.factory.IFood;
import com.esther.code.api.schema.factory.factoryMethod.IFoodFactory;
import com.esther.code.api.schema.service.factory.Rice;

/**
 * @author esther
 * 2018-05-07 11:26
 * $DESCRIPTION}
 */

public class RiceFactory implements IFoodFactory {
    @Override
    public IFood produceFood() {
        System.out.println("---大米厂---");
        return new Rice();
    }
}
