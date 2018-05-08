package com.esther.code.schema.service.decorator;

import com.esther.code.schema.api.decorator.Decorator;
import com.esther.code.schema.api.decorator.IProgrammer;

/**
 * @author esther
 * 2018-05-07 16:46
 * 装饰模式就是给一个对象增加一些新的功能，而且是动态的，要求装饰对象和被装饰对象实现同一个接口，装饰对象持有被装饰对象的实例
 */

public class DesignDecorator extends Decorator {
    public DesignDecorator(IProgrammer programmer) {
        super(programmer);
    }

    @Override
    public void coding() {
        System.out.println("编码前先设计。");
        super.coding();
    }
}
