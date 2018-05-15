package com.zcl.demo;

import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Main14 {
    public static int threadCount = 10;

    public static ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();

    static class Offer implements Runnable {

        @Override
        public void run() {

            if (queue.isEmpty()) {
                String ele = new Random().nextInt(Integer.MAX_VALUE) + "";
                queue.offer(ele);
                System.out.println("入队元素为：" + ele);
            }

        }
    }

    static class Poll implements Runnable {

        @Override
        public void run() {
            if (!queue.isEmpty()) {
                String ele = queue.poll();
                System.out.println("出队元素为" + ele);
            }
        }
    }

    public static Stream<Long> range(final long start, long length, int step) {
        Supplier<Long> seed = new Supplier<Long>() {
            private long next = start;

            @Override
            public Long get() {
                long _next = next;
                next += step;
                return _next;
            }
        };
        return Stream.generate(seed).limit(length);
    }


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        range(1L, 5L, 1).forEach(i -> {
            executorService.submit(new Offer());
            executorService.submit(new Poll());
        });
        executorService.shutdown();

    }
}
