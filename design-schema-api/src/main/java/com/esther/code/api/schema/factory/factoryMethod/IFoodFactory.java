package com.esther.code.api.schema.factory.factoryMethod;

import com.esther.code.api.schema.factory.IFood;

/**
 * @author esther
 * 2018-05-07 11:23
 * 一个工厂生产一个产品，所有产品派生于同一个抽象产品（或产品接口）
 * 工厂模式无法解决产品族和产品等级结构的问题
 */

public interface IFoodFactory {
    IFood produceFood();
}
