package com.esther.code.thread.pool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author esther
 * 2018-06-25 10:44
 * submit(Runnable task) 的时候，错误的堆栈信息跑出来的时候会被内部捕获到，所以打印不出来具体的信息让我们查看,解决的方法有如下两种：
 * 1、使用execute（）代替submit（）；
 * 2、使用Future
 */

public class SubmitDemo {
    public static void main(String[] args) {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").build();
        ExecutorService executorService = new ThreadPoolExecutor(5, 200,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 5; i++) {
            int index = i;
            //executorService.submit(() -> {
        /*    executorService.execute(() -> {
                System.out.println(Thread.currentThread().getName() + ", i=" + index);
                div(100, index);
            });*/

          Future future=  executorService.submit(()->div(100,index));
            try {
                future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
    }

    private static void div(int a, int b) {
        System.out.println(a / b);
    }
}
