package com.esther.code.thread.concurrent;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程间协作的工具类，用于进行线程间的数据交换。它提供一个同步点，在这个同步点，两个线程可以交换彼此的数据，将本线程生产出来的数据传递给对方。
 */
public class ExchangerTest {
    private static final Exchanger<String> exchanger = new Exchanger<>();
    private static ExecutorService executorService = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                String A = "银行流水A";
                try {
                    exchanger.exchange(A);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                String B = "银行流水B";
                try {
                    String A = exchanger.exchange(B);

                    System.out.println(A.equals(B) + ",A=" + A + ",B=" + B);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
