package com.esther.code.thread.concurrent;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    static CountDownLatch cdl=new CountDownLatch(2);
    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                cdl.countDown();
                System.out.println(2);
                cdl.countDown();
            }
        });
        thread.start();
        cdl.await();
        System.out.println(3);
    }
}
