package com.esther.code.schema.api.singleton.lazy;

/**
 * @author esther
 * 2018-05-11 17:17
 * 静态内部类
 */

public class Singleton2 {
    private static class LazyHolder {
        private static final Singleton2 INSTANCE = new Singleton2();
    }
    private Singleton2 (){}
    public static final Singleton2 getInstance() {
        return LazyHolder.INSTANCE;
    }
}
