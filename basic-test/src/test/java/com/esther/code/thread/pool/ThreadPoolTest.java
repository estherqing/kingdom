package com.esther.code.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author esther
 * 2018-06-22 17:38
 * $DESCRIPTION
 */

public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 50; i++) {
            int index = i;
            executorService.submit(() -> {
                System.out.println(Thread.currentThread().getName() + ", i=" + index + "-executorService ");
            });
            int o=1;
        }
        executorService.shutdown();
    }
}
