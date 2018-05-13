package com.zcl.sorted;

import java.util.List;

public class SimpleSelectSort {
    public static void SimpleSelectSort(List<User> users) {
        for (int i = 0; i < users.size(); i++) {
            int k = i;//k存放最小值下标。每次循环最小值下标+1
            for (int j = i + 1; j < users.size(); j++) {//找到最小值下标
                if (Utils.compare(users.get(k), users.get(j)))
                    k = j;
            }
            Utils.swap(users, k, i);//把最小值放到它该放的位置上
        }
    }

    public static void SelectSort(List<User> users) {
        int i, j, min, max, n = users.size();
        for (i = 1; i <= n / 2; i++) {
            // 做不超过n/2趟选择排序
            min = i;
            max = i; //分别记录最大和最小关键字记录位置
            for (j = i + 1; j <= n - i; j++) {
                if (Utils.compare(users.get(j), users.get(max))) {
                    max = j;
                    continue;
                }
                if (Utils.compare(users.get(j), users.get(min))) {
                    min = j;
                }
            }
            //该交换操作还可分情况讨论以提高效率
            Utils.swap(users, i - 1, min);
            Utils.swap(users, n - i, max);

        }
    }


}
