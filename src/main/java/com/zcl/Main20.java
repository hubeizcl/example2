package com.zcl;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Stream;

public class Main20 {
    public static Stream<Long> range(Long index, Long length, Long step) {
        return Stream.generate(() -> {
            Long next = index;
            next += step;
            return next;
        }).limit(length);
    }

    public static class MyCallable implements Callable<Object> {
        private String taskNum;

        public MyCallable(String taskNum) {
            this.taskNum = taskNum;
        }

        @Override
        public Object call() throws Exception {
            System.out.println(">>>" + taskNum + "任务启动");
            Date date = new Date();
            Thread.sleep(1000);
            Date date1 = new Date();
            long l = date.getTime() - date1.getTime();
            System.out.println(">>>" + taskNum + "任务终止");
            return taskNum + "任务返回运行结果,当前任务时间【" + l + "毫秒】 ";
        }
    }

    public static void main(String[] args) {
        System.out.println("----程序开始运行----");
        Date date = new Date();
        int taskSize = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(taskSize);
        ArrayList<Future> futures = new ArrayList<>();
        range(0L, (long) taskSize, 1L).forEach(i -> {
            Callable myCallable = new MyCallable(i + "");
            Future future = executorService.submit(myCallable);
            futures.add(future);
        });
        executorService.shutdown();
        futures.forEach(future -> {
            try {
                System.out.println(">>>" + future.get().toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        Date date1 = new Date();
        System.out.println("----程序结束运行----，程序运行时间【" + (date1.getTime() - date.getTime()) + "毫秒】 ");

    }
}
