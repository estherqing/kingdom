package com.esther.code.schema.service.strategy;

import com.esther.code.schema.api.strategy.IStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author esther
 * 2018-05-23 9:36
 * 环境：纯注解配置
 */
@Component
public class ContextStrategyFactory {
    /** spring在对map注入时，会将类名作为key
     * contreteStrategyA->com.esther.code.schema.service.strategy.ContreteStrategyA@5644dc81
     contreteStrategyB->com.esther.code.schema.service.strategy.ContreteStrategyB@246f8b8b
     IStrategy->org.apache.ibatis.binding.MapperProxy@278bb07e */
    @Autowired
    private Map<String, IStrategy> contextStrategies = new HashMap<>();

    public Map<String, IStrategy> getContextStrategies() {
        return contextStrategies;
    }

    public void setContextStrategies(Map<String, IStrategy> contextStrategies) {
        this.contextStrategies = contextStrategies;
    }

    public IStrategy getStrategy(String type) {
        return this.contextStrategies.get(type);
    }
}
