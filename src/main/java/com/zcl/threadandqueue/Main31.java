package com.zcl.threadandqueue;

public class Main31 {
    public static void main(String[] args) {
        for (int i = 2; i < 1000; i++) {
            int s = 0;
            for (int j = 1; j < i / 2 + 1; j++) {
                if ((i % j) == 0) {
                    s += j;
                }
            }
            if (s == i) {
                System.out.print(i + " its factors are:");
                for (int j = 1; j < i; j++) {
                    if ((i % j) == 0) {
                        System.out.print(j + ",");
                    }
                }
                System.out.println();
            }

        }
    }
}
