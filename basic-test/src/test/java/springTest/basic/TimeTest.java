package springTest.basic;

import java.util.Date;
import java.util.Random;

/**
 * @author esther
 * 2018-03-12 11:29
 * $DESCRIPTION}
 */

public class TimeTest {
    public static void main(String[] args) {
        long a =System.currentTimeMillis();
        long b=new Date().getTime();
        System.out.println(a);
        System.out.println(b);
        long c=0l;
        long d= (long) (Math.random()*10);
        long e=new Random().nextLong();
    }
}
