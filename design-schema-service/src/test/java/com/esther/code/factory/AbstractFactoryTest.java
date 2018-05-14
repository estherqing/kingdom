package com.esther.code.factory;

import com.esther.code.api.schema.factory.abstractFactory.IDiningRoomFactory;
import com.esther.code.api.schema.service.factory.abstractFactory.DiningRoomFactoryA;
import com.esther.code.api.schema.service.factory.abstractFactory.DiningRoomFactoryB;

/**
 * @author esther
 * 2018-05-07 11:43
 * $DESCRIPTION}
 */

public class AbstractFactoryTest {
    public static void main(String[] args) {
        IDiningRoomFactory diningRoomFactory=new DiningRoomFactoryA();
        diningRoomFactory.produceFood().getFood();
        diningRoomFactory.produceDrink().getDrink();

        diningRoomFactory=new DiningRoomFactoryB();
        diningRoomFactory.produceFood().getFood();
        diningRoomFactory.produceDrink().getDrink();
    }
}
   