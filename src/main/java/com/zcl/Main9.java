package com.zcl;

import java.util.concurrent.*;

public class Main9 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int corePoolSize = 5;
        int maximumPoolSize = 10;
        long keepAliveTime = 5000;
        TimeUnit unit = TimeUnit.MILLISECONDS;
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>();
        workQueue.add(()-> System.out.println("123"));
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        Future<String> submit = threadPoolExecutor.submit(() -> {
            return "456";
        });
        System.out.println(submit.get());


    }
}
