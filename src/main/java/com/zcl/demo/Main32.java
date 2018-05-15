package com.zcl.demo;

import java.util.Arrays;

public class Main32 {
    public static void main(String[] args) {
        String[] nums = {"1", "2", "3", "4", "5"};
        combo(nums, 0, 4);
    }

    public static void combo(Object[] array, int start, int end) {

        if (start == end) {
            Arrays.asList(array).forEach(System.out::print);
            System.out.println();
        }

        for (int i = start; i <= end; i++) {
            swap(array, start, i);
            combo(array, start + 1, end);
            swap(array, start, i);
        }
    }

    public static void swap(Object[] array, int a, int b) {
        Object tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }


}
