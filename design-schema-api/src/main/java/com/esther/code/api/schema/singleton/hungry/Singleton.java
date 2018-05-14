package com.esther.code.api.schema.singleton.hungry;

/**
 * @author esther
 * 2018-05-11 17:32
 * $DESCRIPTION}
 */

public class Singleton {
    //    private static Singleton instance = new Singleton();

    // 以下为饿汉式单例的变种，和上面的一样
    private static Singleton instance = null;
    static {
        instance = new Singleton();
    }

    private Singleton() {
    }

    public static Singleton getInstance() {
        return instance;
    }
}
