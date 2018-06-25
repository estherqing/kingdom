package com.esther.code;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author esther
 * 2018-06-22 17:45
 * $DESCRIPTION}
 */

public class Test
{ public static void main(String[] args) {
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
