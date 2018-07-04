package com.esther.code.web.context;

import org.springframework.context.support.AbstractRefreshableApplicationContext;
import org.springframework.web.context.ConfigurableWebApplicationContext;
import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContext;

/**
 * @author esther
 * 2018-05-21 11:51
 * 方案1
 */

public class SpringContextLoaderListener extends ContextLoaderListener {
    @Override
    protected void customizeContext(ServletContext sc, ConfigurableWebApplicationContext wac) {
        super.customizeContext(sc, wac);
        AbstractRefreshableApplicationContext arac = (AbstractRefreshableApplicationContext) wac;
        // 在这里将AbstractRefreshableApplicationContext属性allowBeanDefinitionOverriding设置为false,
        // 这个属性的值最终会传递给DefaultListableBeanFactory类的allowBeanDefinitionOverriding属性
        arac.setAllowBeanDefinitionOverriding(false);
        arac.setAllowCircularReferences(false);
        System.out.println("不允许循环依赖，不允许bean覆盖！");
    }
}
