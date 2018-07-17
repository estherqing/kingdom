package springTest.threadLocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author esther
 * 2018-03-22 15:22
 * $DESCRIPTION}
 */

public class ThreadLocalDebug {
    private static final int THREAD_POOL_SIZE = 2;
    private static ThreadLocal<String> threadLocal1 = new ThreadLocal<>();
    private static ThreadLocal<String> threadLocal2 = new ThreadLocal<>();
    private static ThreadLocal<String> threadLocal3 = new ThreadLocal<>();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
  /*      for (int i = 0; i < THREAD_POOL_SIZE; i++) {
            executorService.execute(() -> {
                System.out.println("----------");
                threadLocal1.set("123");
                threadLocal2.set("456");
                threadLocal3.set("789");
                Thread t = Thread.currentThread();
                System.out.println(t.getName());
                System.out.println("111111111111");
            });
        }*/

        new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal1.set("123");
                threadLocal2.set("456");
                threadLocal3.set("789");
                Thread t = Thread.currentThread();
                System.out.println(t.getName()+threadLocal1.get());
            }
        }).run();

        new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal1.set("111");
                threadLocal2.set("456");
                threadLocal3.set("789");
                Thread t = Thread.currentThread();
                System.out.println(t.getName()+threadLocal1.get());
            }
        }).run();
    }
}
