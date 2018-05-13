package com.zcl;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class Main17 {
    public static void main(String[] args) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        atomicBoolean.getAndSet(true);
        atomicBoolean.compareAndSet(true, false);
        System.out.println(atomicBoolean.get());

        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.set(100);
        int andIncrement = atomicInteger.getAndIncrement();
        System.out.println(andIncrement);
        AtomicInteger atomicInteger1 = new AtomicInteger(andIncrement);
        int andAdd = atomicInteger1.getAndAdd(101);
        System.out.println(andAdd);

        int[] ints = {1, 2, 3};
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(ints);
        atomicIntegerArray.getAndSet(1, 5);

    }
}

class Test {
    private volatile int count = 0;

    public synchronized void increment() {
        count++; //若要线程安全执行执行 count++，需要加锁
    }

    public int getCount() {
        return count;
    }
}

class Test2 {
    private AtomicInteger count = new AtomicInteger();

    public void increment() {
        count.incrementAndGet();
    }

    //使用 AtomicInteger 之后，不需要加锁，也可以实现线程安全。
    public int getCount() {
        return count.get();
    }
}