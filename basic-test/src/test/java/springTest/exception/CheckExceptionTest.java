package springTest.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author esther
 * 2018-01-09 11:35
 * $DESCRIPTION}
 */

public class CheckExceptionTest {
    public static void main(String[] args) {
        // 因为test()方法声明抛出FileNotFoundException异常，所以调用该方法的代码要么放在try...catch块中，要么处于另一个带throws声明抛出的方法里。
        try {
            testCheckedException();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            throwChecked(5);
        } catch (Exception e) {
            e.printStackTrace();
        }
        throwRuntime(5);
    }

    private static void testCheckedException() throws FileNotFoundException {
        // 因为FileInputStream的构造器声明抛出FileNotFoundException异常，所以调用FileInputStream的方法要么放在try...catch块中，要么处于另一个带throws声明抛出的方法里。
        FileInputStream fis = new FileInputStream("a.txt");
    }

    private static void throwChecked(int a) throws Exception {
        if (a > 0) {
            throw new Exception("值大于0，checked exception.");
        }
    }

    private static void throwRuntime(int a) {
        if (a > 0) {
            throw new RuntimeException("值大于0，runtime exception.");
        }
    }
}
