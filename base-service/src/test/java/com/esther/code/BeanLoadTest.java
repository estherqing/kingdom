package com.esther.code;

import com.esther.code.entity.Parent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author esther
 * 2018-05-16 11:10
 * $DESCRIPTION}
 */

public class BeanLoadTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:/spring/applicationContext.xml");
        //CacheKeyGenerator cacheKeyGenerator= (CacheKeyGenerator) applicationContext.getBean("cacheKeyGenerator");
        Parent parent= (Parent) applicationContext.getBean("parent");

        System.out.println(parent);
        System.out.println("--------------------");
    }
}
