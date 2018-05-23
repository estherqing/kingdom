package com.esther.code.schema.service.factory.abstractFactory;

import com.esther.code.schema.api.factory.IDrink;
import com.esther.code.schema.api.factory.IFood;
import com.esther.code.schema.api.factory.abstractFactory.IDiningRoomFactory;
import com.esther.code.schema.service.factory.Cocacola;
import com.esther.code.schema.service.factory.Rice;

/**
 * @author esther
 * 2018-05-07 11:34
 * $DESCRIPTION}
 */

public class DiningRoomFactoryB implements IDiningRoomFactory {
    @Override
    public IFood produceFood() {
        System.out.println("---食堂B---");
        return new Rice();
    }

    @Override
    public IDrink produceDrink() {
        System.out.println("---食堂B---");
        return new Cocacola();
    }
}
