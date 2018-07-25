package springTest.mad_java;

/**
 * @author esther
 * 2018-01-12 10:25
 * $DESCRIPTION}
 */


public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        classLoader.loadClass("springTest.mad_java.Tester");// 类加载
        System.out.println("加载类");
        Class.forName("springTest.mad_java.Tester");// 类初始化
       /* 加载类
        静态初始化块。。。。
        */
    }
}

class Tester {
    static {
        System.out.println("静态初始化块。。。。");
    }
}