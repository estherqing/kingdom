package com.esther.code.java;

/**
 * @author esther
 * 2018-07-12 9:37
 * $DESCRIPTION}
 */

public class JVMInitTest {
    public static final int num=10;
    static{
        System.out.println("这是JVMInitTest的静态代码块。");
    }

    public static void main(String[] args) {
        System.out.println(JVMInitTest.num);
        System.out.println(JTest.ccount);
    }
}
class JTest{
    // 注意，这里的final关键字不可缺少，我们知道变量被关键字fianl修饰之后就不可修改，亦即此变量相当于编译期常量（是相当于并非就是常量），常量在java编译期已经确定，不需要初始化
    // 把final去掉，count值在编译期不能确定，就必须经过初始化才能使用count的值
    public static final int ccount=100;
    static{
        System.out.println("这是JTest的静态代码块。");
    }
}
