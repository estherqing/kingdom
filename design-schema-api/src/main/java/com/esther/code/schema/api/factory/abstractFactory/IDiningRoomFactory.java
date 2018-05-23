package com.esther.code.schema.api.factory.abstractFactory;

import com.esther.code.schema.api.factory.IDrink;
import com.esther.code.schema.api.factory.IFood;

/**
 * @author esther
 * 2018-05-07 11:33
 * 抽象工厂模式中，一个工厂生产多个产品，它们是一个产品族，不同的产品族的产品派生于不同的抽象产品（或产品接口）
 */

public interface IDiningRoomFactory {
    IFood produceFood();
    IDrink produceDrink();
}
