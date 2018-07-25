package com.esther.code.factoryBean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author esther
 * 2018-07-24 17:33
 * $DESCRIPTION}
 */

public class FactoryBeanTest {
    static ApplicationContext context = null;

    static {
        String[] xmls = {"/applicationContext.xml"};
        context = new ClassPathXmlApplicationContext(xmls);
    }

    @Test
    public void test() {
        Car car = (Car) context.getBean("car");
        System.out.println(car);

        CarFactoryBean carFactoryBean = (CarFactoryBean) context.getBean("&car");
        System.out.println(carFactoryBean);
    }
}
