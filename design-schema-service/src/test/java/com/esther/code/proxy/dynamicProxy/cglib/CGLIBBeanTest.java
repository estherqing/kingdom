package com.esther.code.proxy.dynamicProxy.cglib;

import com.esther.code.api.schema.service.proxy.dynamicProxy.cglib.CGLIBBean;

import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * @author esther
 * 2018-04-27 15:10
 * $DESCRIPTION}
 */

public class CGLIBBeanTest {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws ClassNotFoundException { // 设置类成员属性
        HashMap<String, Class> propertyMap = new HashMap<>();
        propertyMap.put("id", Class.forName("java.lang.Integer"));
        propertyMap.put("name", Class.forName("java.lang.String"));
        propertyMap.put("address", Class.forName("java.lang.String")); // 生成动态Bean
        CGLIBBean bean = new CGLIBBean(propertyMap);
        // 给Bean设置值
        bean.setValue("id", 123);  //Auto-boxing
        bean.setValue("name", "454");
        bean.setValue("address", "789");
        // 从Bean中获取值，当然获得值的类型是Object
        System.out.println(" >> id = " + bean.getValue("id"));
        System.out.println(" >> name = " + bean.getValue("name"));
        System.out.println(" >> address = " + bean.getValue("address"));
        // 获得bean的实体
        Object object = bean.getObject();
        // 通过反射查看所有方法名
        Class clazz = object.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method curMethod : methods) {
            System.out.println(curMethod.getName());
        }
    }
}
