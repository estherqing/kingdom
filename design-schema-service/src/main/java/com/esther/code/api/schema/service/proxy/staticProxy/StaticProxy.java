package com.esther.code.api.schema.service.proxy.staticProxy;

import com.esther.code.api.schema.proxy.IHello;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author esther
 * 2018-04-25 16:25
 * 与核心业务有关的辅助性操作
 */
public class StaticProxy implements IHello {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private IHello iHello;

    public StaticProxy(IHello iHello){
        this.iHello=iHello;
    }

    @Override
    public void sayHello(String name) {
        logger.info(System.currentTimeMillis()+"：开始！");
        iHello.sayHello(name);
        logger.info(System.currentTimeMillis()+"：结束！");
    }
}
