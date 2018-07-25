package com.esther.code.base;

/**
 * @author esther
 * 2018-07-17 14:19
 * (1)break 跳出当前循环体
 * (2)continue 跳过当前循环体continue后面的代码，继续执行下一个循环
 */

public class BreakContinueTest {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                break;
            }
            System.out.println(i);
        }
        System.out.println("------------------------");
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                continue;
            }
            System.out.println(i);
        }
    }
}
