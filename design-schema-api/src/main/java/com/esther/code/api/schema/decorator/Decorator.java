package com.esther.code.api.schema.decorator;

/**
 * @author esther
 * 2018-05-07 16:42
 * 装饰模式就是给一个对象增加一些新的功能，而且是动态的，要求装饰对象和被装饰对象实现同一个接口，装饰对象持有被装饰对象的实例
 */

public abstract class Decorator implements IProgrammer {
    private IProgrammer programmer;
    public Decorator(IProgrammer programmer){
        super();
        this.programmer=programmer;
    }
    @Override
    public void coding() {
        programmer.coding();
    }
}
