package com.zcl.threadandqueue;

import java.util.PriorityQueue;
import java.util.concurrent.*;

public class Main13 {
    public static void main(String[] args) {
        BlockingQueue<String> strings = new LinkedBlockingQueue<>(100);
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(10);
        DelayQueue<Delayed> delayeds = new DelayQueue<>();
        delayeds.put(new Delayed() {
            @Override
            public long getDelay(TimeUnit unit) {
                return 1000;
            }

            @Override
            public int compareTo(Delayed o) {
                return 1000;
            }
        });
        PriorityQueue<Comparable> comparables = new PriorityQueue<>();
        comparables.offer(new Comparable() {
            @Override
            public int compareTo(Object o) {
                return 1;
            }
        });

        SynchronousQueue<String> queue1 = new SynchronousQueue<>();
    }
}

