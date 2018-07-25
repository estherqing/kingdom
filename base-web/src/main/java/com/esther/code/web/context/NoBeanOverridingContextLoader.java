package com.esther.code.web.context;

import org.springframework.context.support.AbstractRefreshableApplicationContext;
import org.springframework.web.context.ConfigurableWebApplicationContext;
import org.springframework.web.context.ContextLoader;

import javax.servlet.ServletContext;

/**
 * @author esther
 * 2018-05-17 15:30
 * 方案3
 */

public class NoBeanOverridingContextLoader extends ContextLoader{
    @Override
    protected void customizeContext(ServletContext sc, ConfigurableWebApplicationContext wac) {
        super.customizeContext(sc, wac);
        AbstractRefreshableApplicationContext arac= (AbstractRefreshableApplicationContext) wac;
        // 在这里将AbstractRefreshableApplicationContext属性allowBeanDefinitionOverriding设置为false,
        // 这个属性的值最终会传递给DefaultListableBeanFactory类的allowBeanDefinitionOverriding属性
        arac.setAllowBeanDefinitionOverriding(false);
        arac.setAllowCircularReferences(false);
    }
}
