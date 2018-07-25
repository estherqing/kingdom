package com.esther.code;

import com.esther.code.api.IUserService;
import com.esther.code.entity.Parent;

import com.esther.code.service.impl.UserServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.net.URL;
import java.util.Enumeration;

/**
 * @author esther
 * 2018-05-16 11:10
 * $DESCRIPTION}
 */

public class BeanLoadTest {
    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/applicationContextTest.xml");
        Parent parent = (Parent) applicationContext.getBean("parent");
        System.out.println(parent);
        System.out.println("--------------------");

        IUserService userService = (IUserService) applicationContext.getBean("userService");
        System.out.println(userService.selectByPrimaryKey(1));



      /*  Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources("com/alibaba/dubbo/registry/internal/DefaultRegistryService.class");
        while (urls.hasMoreElements()) {
            URL url = urls.nextElement();
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>" + url.getFile());
        }*/
    }
}
