package com.zcl.threadandqueue;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main5 {
    public static void main(String[] args) {
//        ExecutorService pool = Executors.newFixedThreadPool(2);
//        ExecutorService pool = Executors.newSingleThreadExecutor();
//        ExecutorService pool = Executors.newCachedThreadPool();
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(2);
        Thread t1 = new MyThread();
        Thread t2 = new MyThread();
        Thread t3 = new MyThread();
        Thread t4 = new MyThread();
        Thread t5 = new MyThread();
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.schedule(t4, 10, TimeUnit.MICROSECONDS);
        pool.schedule(t5, 10, TimeUnit.MICROSECONDS);
        pool.shutdown();

    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "正在执行....");
    }
}