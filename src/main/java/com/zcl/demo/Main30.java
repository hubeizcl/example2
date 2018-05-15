package com.zcl.demo;

public class Main30 {
    public static void main(String[] args) {
        Resource resource = new Resource();
        Producer producer = new Producer(resource);
        Consumer consumer = new Consumer(resource);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}

class Resource {
    private String name;
    private int count = 1;
    private boolean flag = false;

    public synchronized void set(String name) {
        while (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.name = name + "---" + count++;
        System.out.println(Thread.currentThread().getName() + "...生产者..." + this.name);
        flag = true;
        this.notifyAll();
    }

    public synchronized void out() {
        while (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "...消费者..." + this.name);
            flag = false;
            this.notifyAll();
        }
    }
}

class Producer implements Runnable {
    private Resource res;

    public Producer(Resource res) {
        this.res = res;
    }

    @Override
    public void run() {
        while (true) {
            res.set("商品");
        }
    }
}

class Consumer implements Runnable {
    private Resource res;

    public Consumer(Resource res) {
        this.res = res;
    }

    @Override
    public void run() {
        while (true) {
            res.out();
        }
    }
}
