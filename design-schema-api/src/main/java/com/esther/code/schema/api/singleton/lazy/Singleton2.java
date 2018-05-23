package com.esther.code.schema.api.singleton.lazy;

/**
 * @author esther
 * 2018-05-11 17:17
 * 静态内部类
 * 特点：既能实现延迟加载，又能实现线程安全
 */

public class Singleton2 {
    /**
     * 类级的内部类，也就是静态的成员式内部类，该内部类的实例与外部类的实例没有绑定关系，而且只有被调用到时才会装载(装在过程是由jvm保证线程安全)
     * ，从而实现了延迟加载
     */
    private static class LazyHolder {
        /**
         * 静态初始化器，由JVM来保证线程安全
         */
        private static final Singleton2 INSTANCE = new Singleton2();
    }
    private Singleton2 (){}
    /**
     这个模式的优势在于：getInstance方法并没有被同步，并且只是执行一个域的访问，因此延迟初始化并没有增加任何访问成本
     */
    public static final Singleton2 getInstance() {
        return LazyHolder.INSTANCE;
    }
}
