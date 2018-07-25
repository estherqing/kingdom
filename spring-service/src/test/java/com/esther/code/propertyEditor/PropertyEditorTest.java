package com.esther.code.propertyEditor;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author esther
 * 2018-07-25 10:25
 * $DESCRIPTION}
 */

public class PropertyEditorTest {
    static ApplicationContext context = null;

    static {
        String[] xmls = {"/applicationContext.xml"};
        context = new ClassPathXmlApplicationContext(xmls);
    }

    @Test
    public void test() {
        Boss boss = (Boss) context.getBean("boss");
        System.out.println(boss);
        System.out.println(boss.getDate());
    }
}
