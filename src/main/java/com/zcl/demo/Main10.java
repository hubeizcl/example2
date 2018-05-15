package com.zcl.demo;

import java.util.concurrent.*;

public class Main10 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        ScheduledFuture<String> schedule = scheduledExecutorService.schedule(() -> {
            System.out.println("Executed!");
            return "Called!";
        }, 5, TimeUnit.MILLISECONDS);
        System.out.println(schedule.get());

        scheduledExecutorService.scheduleAtFixedRate(() -> System.out.println("123"), 1000, 2000, TimeUnit.MILLISECONDS);

        scheduledExecutorService.scheduleWithFixedDelay(() -> System.out.println("123"), 1000, 2000, TimeUnit.MILLISECONDS);

        scheduledExecutorService.shutdownNow();


    }
}
