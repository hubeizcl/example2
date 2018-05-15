package com.zcl.demo;

public class Main26 implements Runnable {
    public boolean flag = false;

    private static Object o1 = new Object(), o2 = new Object();

    @Override
    public void run() {
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
        Main26 main261=new Main26();
        Main26 main262=new Main26();
        main261.flag=false;
        main262.flag=true;
        new Thread(main261).start();
        new Thread(main262).start();
    }
}
