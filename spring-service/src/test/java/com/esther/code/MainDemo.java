package com.esther.code;


import com.esther.code.spring.model.Log;
import org.springframework.util.ClassUtils;

import java.util.ArrayList;
import java.util.Set;

/**
 * @author esther
 * 2018-06-26 9:49
 * $DESCRIPTION}
 */

public class MainDemo {
    public static void main(String[] args) {
        Class<?>[] classes=   ClassUtils.getAllInterfaces(Log.class);
        System.out.println(classes);

        // 如果是类，返回该类实现的接口；如果是接口，返回该接口
        Set<Class<?>> s= ClassUtils.getAllInterfacesForClassAsSet(Log.class);
        System.out.println(s);

        /** Class类的isAssignableFrom(cls)方法：
         *  如果调用这个方法的类或接口是参数cls的父类或相同，则返回true，否则返回false
         */
        System.out.println(ArrayList.class.isAssignableFrom(Object.class));// false
        System.out.println(Object.class.isAssignableFrom(ArrayList.class));// true

        System.out.println();
    }
}
