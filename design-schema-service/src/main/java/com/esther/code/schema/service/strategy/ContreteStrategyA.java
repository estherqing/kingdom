package com.esther.code.schema.service.strategy;

import com.esther.code.schema.api.strategy.IStrategy;
import org.springframework.stereotype.Component;

/**
 * @author esther
 * 2018-05-22 15:45
 * 具体策略类
 */
@Component
public class ContreteStrategyA implements IStrategy {
    @Override
    public void sayHello(String name) {
        System.out.println("阿里集团欢迎你："+name);
    }
}
