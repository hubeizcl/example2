package com.zcl;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class Main18 {
    static AtomicIntegerArray arr = new AtomicIntegerArray(10);

    public static class AddThread implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                arr.getAndIncrement(i % arr.length());
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new AddThread());
        }
        for (int k = 0; k < 10; k++) {
            threads[k].start();
        }
        for (int k = 0; k < 10; k++) {
            threads[k].join();
        }
        System.out.println(arr);
    }
}
