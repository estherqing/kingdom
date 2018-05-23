package com.esther.code.schema.service.strategy;

import com.esther.code.schema.api.strategy.IStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author esther
 * 2018-05-23 9:36
 * 环境：xml配置
 */
public class XmlContextStrategyFactory {

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
