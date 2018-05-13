package com.zcl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Supplier;
import java.util.stream.Stream;


public class Main19 {

    public static Stream<Long> range(Long startIndex, Long length, Long step) {
        Supplier<Long> seed = new Supplier<Long>() {
            @Override
            public Long get() {
                Long next = startIndex;
                next += step;
                return next;
            }
        };
        return Stream.generate(seed).limit(length);

    }

    public static void main(String[] args) {
        AtomicLong atomicLong = new AtomicLong(0L);
        List<Item> orders = Collections.synchronizedList(new ArrayList<Item>());
        range(0L, 10L, 1L).forEach(i -> {
            Thread thread = new Thread(() -> {
                range(0L, 10L, 1L).forEach(j -> {
                    long orderId = atomicLong.incrementAndGet();
                    Item item = new Item(Thread.currentThread().getName(), orderId);
                    orders.add(item);
                });
            });
            thread.setName("Order Creation Thread" + i);
            thread.start();
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        HashSet<Long> longs = new HashSet<>();
        orders.stream().forEach(item -> {
            longs.add(item.getId());
            System.out.println("Order name:" + item.getItemName() + "----" + "Order id:" + item.getId());
        });

    }
}

class Item {
    String itemName;
    Long id;

    public Item(String itemName, Long id) {
        this.itemName = itemName;
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public Long getId() {
        return id;
    }
}