package com.esther.code.web.context;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * @author esther
 * 2018-05-21 19:18
 * 方案2
 */

public class SpringApplicationContextInitializer implements ApplicationContextInitializer<XmlWebApplicationContext> {
    @Override
    public void initialize(XmlWebApplicationContext applicationContext) {
        /** 在这里将XmlWebApplicationContext属性allowBeanDefinitionOverriding设置为false,
         * 这个属性的值最终会传递给DefaultListableBeanFactory类的allowBeanDefinitionOverriding属性  */
        applicationContext.setAllowBeanDefinitionOverriding(false);
    }
}
