package com.esther.code.atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerTest {
    static AtomicInteger ai=new AtomicInteger(1);

    static int[] value=new int[]{1,2};
    static AtomicIntegerArray aia=new AtomicIntegerArray(value);

    public static void main(String[] args) {
        System.out.println(ai.getAndIncrement());
        System.out.println(ai.get());

        aia.getAndSet(0,3);
        System.out.println(aia.get(0));
        System.out.println(value[0]);

    }
}
