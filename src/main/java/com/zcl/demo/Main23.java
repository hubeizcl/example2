package com.zcl.demo;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main23 {
    public static void main(String[] args) throws InterruptedException {
        int corePoolSize = 5;
        int maximumPoolSize = 10;
        long keepAliveTime = 5000;
        TimeUnit unit = TimeUnit.MILLISECONDS;
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>();
        int[] num = {0};
        workQueue.add(() -> {
            num[0] += 2;
            System.out.println(Thread.currentThread().getName() + "获取到 num 的值为： " + num[0]);
        });
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        threadPoolExecutor.submit(() -> System.out.println(Thread.currentThread().getName() + "获取到 num 的值为： " + num[0]));
        threadPoolExecutor.submit(() -> System.out.println(Thread.currentThread().getName() + "获取到 num 的值为： " + num[0]));
        threadPoolExecutor.shutdown();

    }
}
