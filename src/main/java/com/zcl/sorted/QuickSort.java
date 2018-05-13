package com.zcl.sorted;

import java.util.List;

public class QuickSort {

    public static void sort(List<User> users, int right, int left) {
        int i, j, flag = right;
        if (right > left) return;
        i = right;
        j = left;
        User index = users.get(i); // 用子表的第一个记录做基准
        while (i < j) { // 从表的两端交替向中间扫描
            while (i < j && Utils.compare(users.get(j), index)) j--;
            if (i < j) Utils.swap(users, i++, j);// 用比基准小的记录替换低位记录
            while (i < j && Utils.compare(users.get(i), index)) i++;
            if (i < j) Utils.swap(users, j--, i); // 用比基准大的记录替换高位记录
        }
        Utils.swap(users, i, flag);        // 将基准数值替换回
        sort(users, right, i - 1); // 对低子表进行递归排序
        sort(users, i + 1, left); // 对高子表进行递归排序
    }
}


