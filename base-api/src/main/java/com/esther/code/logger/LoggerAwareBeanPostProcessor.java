package com.esther.code.logger;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class LoggerAwareBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof LoggerWrapperAware) {
            ((LoggerWrapperAware) bean).setLogger(LoggerUtil.getLoggerWrapper(bean.getClass()));
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        /*if (bean instanceof LoggerWrapperAware) {
            ((LoggerWrapperAware) bean).setLogger(LoggerUtil.getLoggerWrapper(beanName));
        }*/
        return bean;
    }
}
