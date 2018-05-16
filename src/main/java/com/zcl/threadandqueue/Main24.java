package com.zcl.threadandqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Main24 {
    private static int num;

    private static Semaphore semaphore = new Semaphore(0);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Runnable> runnableList = new ArrayList<>();
        runnableList.add(() -> {
            try {
                Thread.sleep(1000);
                num = 1;
                semaphore.release(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        runnableList.add(() -> {
            try {
                semaphore.acquire(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "获取到 num 的值为： " + num);
        });
        runnableList.add(() -> {
            try {
                semaphore.acquire(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "获取到 num 的值为： " + num);
        });
        executorService.execute(runnableList.get(0));
        executorService.execute(runnableList.get(1));
        executorService.execute(runnableList.get(2));
    }
}
