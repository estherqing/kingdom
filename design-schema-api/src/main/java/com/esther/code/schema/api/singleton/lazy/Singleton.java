package com.esther.code.schema.api.singleton.lazy;

/**
 * @author esther
 * 2018-05-11 17:03
 * 懒汉式单例类.在第一次调用的时候实例化自己
 */
public class Singleton {
    private Singleton() {
    }

    private static Singleton singleton;

    //静态工厂方法
    // 线程不安全
    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
//    以下为线程安全的实现方法

    // 加synchronized关键字
   /* public static synchronized Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }*/

    // 双重校验锁
/*    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }*/
}
