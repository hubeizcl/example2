package com.zcl;

public class Main3 {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        for (int i = 0; i < 4; i++) {
            if (i % 2 == 0) {
                new Thread(new RunnableCusToInc(shareData), "Thread " + i).start();
            } else {
                new Thread(new RunnableCusToDec(shareData), "Thread " + i).start();
            }
        }
    }
}


//封装共享数据类
class RunnableCusToDec implements Runnable {
    //封装共享数据
    private ShareData shareData;

    public RunnableCusToDec(ShareData data) {
        this.shareData = data;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            shareData.inc();
        }
    }
}

