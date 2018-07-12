package com.esther.code.java;

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
    }
}
