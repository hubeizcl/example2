package com.zcl;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main25 {
    private int count = 0;
    private Lock lock = new ReentrantLock();

    public Runnable runnable1 = new Runnable() {
        @Override
        public void run() {
//            lock.lock();
            synchronized (this) {
                while (count < 1000) {
                    System.out.println(Thread.currentThread().getName() + " run1: " + count++);
                }
            }
//            lock.unlock();
        }
    };
    public Runnable runnable2 = new Runnable() {
        @Override
        public void run() {
//            lock.lock();
            synchronized (this) {
                while (count < 1000) {
                    System.out.println(Thread.currentThread().getName() + " run2: " + count++);
                }
            }
//            lock.unlock();
        }
    };


    public static void main(String[] args) {
        Main25 main25 = new Main25();
        new Thread(main25.runnable1).start();
        new Thread(main25.runnable2).start();
    }
}
