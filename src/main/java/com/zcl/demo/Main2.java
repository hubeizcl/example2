package com.zcl.demo;

public class Main2 {

    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        for (int i = 0; i < 4; i++) {
            new Thread(new RunnableCusToInc(shareData), "Thread " + i).start();
        }
    }
}


/**
 * 共享数据类
 **/
class ShareData {
    private int num = 10;

    public synchronized void inc() {
        num++;
        System.out.println(Thread.currentThread().getName() + ": invoke inc method num =" + num);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void dec() {
        num--;
        System.err.println(Thread.currentThread().getName() + ": invoke dec method num =" + num);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 多线程类
 **/
class RunnableCusToInc implements Runnable {

    private ShareData shareData;

    public RunnableCusToInc(ShareData data) {
        this.shareData = data;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            shareData.inc();
        }
    }
}