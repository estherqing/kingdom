package com.esther.code.thread.pool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author esther
 * 2018-06-22 17:38
 * $DESCRIPTION
 */

public class ThreadPoolTest {
    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newFixedThreadPool(5);// 不推荐的写法



    /*    ExecutorService executorService= new ThreadPoolExecutor(5, 200,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());*/

 /*     ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").build();
        ExecutorService executorService= new ThreadPoolExecutor(5, 200,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());*/

        ExecutorService executorService = new ThreadPoolExecutor(5, 5,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName(r.getClass().getName());
                return thread;
            }
        }, new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 5; i++) {
            int index = i;
            executorService.submit(() -> {
                System.out.println(Thread.currentThread().getName() + ", i=" + index);
            });
        }
        executorService.shutdown();
    }
}
