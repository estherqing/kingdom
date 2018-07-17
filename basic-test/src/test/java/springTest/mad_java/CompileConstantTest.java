package springTest.mad_java;

/**
 * @author esther
 * 2018-01-12 10:23
 * $DESCRIPTION}
 */

public class CompileConstantTest {
    public static void main(String[] args) {
        System.out.println(ConstantTest.time);
    }
}
class ConstantTest{
    static{
        System.out.println("静态初始化块。。。。");
    }
    static final String constantStr="constant";// 类不会初始化

    static final Long time = System.currentTimeMillis();// 类初始化
}
