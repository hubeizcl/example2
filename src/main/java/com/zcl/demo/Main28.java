package com.zcl.demo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main28 {
    private static Object o1 = new Object(), o2 = new Object();

    public void money(boolean flag) {
        if (flag) {
            synchronized (o1) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    System.out.println("1");
                }
            }
        }
        if (!flag) {
            synchronized (o2) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                    System.out.println("0");
                }
            }
        }
    }

    public static void main(String[] args) {
        Main28 main271 = new Main28();
        Main28 main272 = new Main28();
        Lock lock = new ReentrantLock();

        final boolean[] flag = {false};
        new Thread(() -> {
            try {
                String tName = Thread.currentThread().getName();
                if (lock.tryLock(5000, TimeUnit.MILLISECONDS)) {
                    System.out.println(tName + "获取到锁！ ");
                } else {
                    System.out.println(tName + "获取不到锁！ ");
                    return;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                main271.money(flag[0]);
                lock.unlock();
            }
        }
        ).start();
        new Thread(() -> {
            flag[0] = true;
            try {
                String tName = Thread.currentThread().getName();
                if (lock.tryLock(5000, TimeUnit.MILLISECONDS)) {
                    System.out.println(tName + "获取到锁！ ");
                } else {
                    System.out.println(tName + "获取不到锁！ ");
                    return;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                main272.money(flag[0]);
                lock.unlock();
            }
        }).start();
    }
}
