package com.esther.code.service.factory.abstractFactory;

import com.esther.code.api.factory.IDrink;
import com.esther.code.api.factory.IFood;
import com.esther.code.api.factory.abstractFactory.IDiningRoomFactory;
import com.esther.code.service.factory.Noodle;
import com.esther.code.service.factory.Water;

/**
 * @author esther
 * 2018-05-07 11:34
 * $DESCRIPTION}
 */

public class DiningRoomFactoryA implements IDiningRoomFactory {
    @Override
    public IFood produceFood() {
        System.out.println("---食堂A---");
        return new Noodle();
    }

    @Override
    public IDrink produceDrink() {
        System.out.println("---食堂A---");
        return new Water();
    }
}
