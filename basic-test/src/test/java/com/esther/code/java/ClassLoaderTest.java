package com.esther.code.java;

import java.util.List;

/**
 * @author esther
 * 2018-07-11 14:51
 * $DESCRIPTION}
 */

public class ClassLoaderTest {
    public static void main(String[] args) {
        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader().getParent());
        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());

     /*   sun.misc.Launcher$AppClassLoader@18b4aac2
        sun.misc.Launcher$ExtClassLoader@6acbcfc0
        null*/

        MyClassLoader myClassLoader = new MyClassLoader("E:\\IdeaProjects\\kingdom\\basic-test\\target\\test-classes\\");
        Class<?> clas = myClassLoader.findClass("com.esther.code.java.Test");
        System.out.println(clas);

        //输出ClassLoaderText的类加载器名称
        System.out.println("ClassLoaderText类的加载器的名称: "+ClassLoaderTest.class.getClassLoader().getClass().getName());
        System.out.println("System类的加载器的名称: "+System.class.getClassLoader());
        System.out.println("List类的加载器的名称: "+List.class.getClassLoader());

        // 1、ClassLoaderTest类是用户定义的类，位于CLASSPATH下，由系统/应用程序类加载器加载。

       // 2、System类与List类都属于Java核心类，由祖先类启动类加载器加载，而启动类加载器是在JVM内部通过C/C++实现的，并不是Java，自然也就不能继承ClassLoader类，自然就不能输出其名称。

        ClassLoader cl = ClassLoaderTest.class.getClassLoader();
        while(cl != null){
            System.out.print(cl.getClass().getName()+" -> ");
            cl = cl.getParent();
        }
        System.out.println(cl);
    }
}
