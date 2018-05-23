package com.esther.code.strategy;

import com.esther.code.base.BaseService;
import com.esther.code.schema.api.strategy.IStrategy;
import com.esther.code.schema.service.strategy.ContextStrategyFactory;
import com.esther.code.schema.service.strategy.XmlContextStrategyFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;
import java.util.Map;


/**
 * @author esther
 * 2018-05-23 9:38
 * $DESCRIPTION}
 */

public class StrategyTest extends BaseService {
    @Autowired
    private ContextStrategyFactory contextStrategyFactory;

    @Resource
    private XmlContextStrategyFactory xmlContextStrategyFactory;

    //IStrategy有多个实现类，使用@Autowired时必须使用@Qualifier指定具体实现类
    @Autowired
    @Qualifier("contreteStrategyB")
    private IStrategy strategy;

    @Test
    public void test() {
        Map<String, IStrategy> strategyMap = contextStrategyFactory.getContextStrategies();
        for (Map.Entry<String, IStrategy> entry : strategyMap.entrySet()) {
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }
        IStrategy iStrategy = contextStrategyFactory.getStrategy("contreteStrategyB");
        iStrategy.sayHello("esther");
    }

    @Test
    public void testXml() {
        Map<String, IStrategy> strategyMap = xmlContextStrategyFactory.getContextStrategies();
        for (Map.Entry<String, IStrategy> entry : strategyMap.entrySet()) {
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }
        IStrategy iStrategy = contextStrategyFactory.getStrategy("contreteStrategyB");
        iStrategy.sayHello("esther");
        System.out.println(xmlContextStrategyFactory);
    }

    @Test
    public void testClass(){
        strategy.sayHello("esther");
    }
}
