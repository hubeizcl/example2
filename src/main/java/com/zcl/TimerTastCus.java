package com.zcl;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTastCus extends TimerTask {
    private static int count = 0;

    @Override
    public void run() {
        count = (count + 1) % 2;
        System.err.println("Boob boom ");
        new Timer().schedule(new TimerTastCus(), 2000 + 2000 * count);
    }

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTastCus(), 2000 + 2000 * count);
        while (true) {
            System.out.println(new Date().getSeconds());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
