package com.esther.code.api.schema.singleton;


/**
 *
 * 枚举实现线程安全的单例模式:
 * 特点：JVM会保证enum不能被反射并且构造器方法只执行一次
 *
 */
public class EnumSingleton {
    private EnumSingleton() {
    }

    public static EnumSingleton getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    private static enum Singleton {
        INSTANCE;

        private EnumSingleton singleton;

        // JVM会保证此方法绝对只调用一次
        private Singleton() {
            singleton = new EnumSingleton();
        }

        public EnumSingleton getInstance() {
            return singleton;
        }
    }
}