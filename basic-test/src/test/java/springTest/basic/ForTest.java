package springTest.basic;

/**
 * @author esther
 * @create 2017-10-16 15:00
 * $DESCRIPTION}
 */

public class ForTest {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            if (i == 3) {
                System.out.println("i=3");
                continue;
            }
            System.out.println("hello");
        }
    }
}
