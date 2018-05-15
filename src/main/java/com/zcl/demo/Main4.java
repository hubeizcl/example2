package com.zcl.demo;

public class Main4 {
    public static void main(String[] args) {
        //公共数据
        final ShareData shareData = new ShareData();
        for (int i = 0; i < 4; i++) {
            if (i % 2 == 0) {
                new Thread(() -> {
                    for (int j = 0; j < 5; j++) {
                        shareData.inc();
                    }
                }, "Thread " + i).start();
            } else {
                new Thread(() -> {
                    for (int j = 0; j < 5; j++) {
                        shareData.dec();
                    }
                }, "Thread " + i).start();

            }
        }
    }
}
