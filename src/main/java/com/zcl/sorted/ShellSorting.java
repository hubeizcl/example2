package com.zcl.sorted;

import java.util.List;

public class ShellSorting {

    public static void shellSorting(List<User> users) {
        int amount = users.size() / 2;
        while (amount >= 1) {
            for (int i = amount; i < users.size(); i++) {
                if (Utils.compare(users.get(i), users.get(i - amount))) {
                    int j;
                    User x = users.get(i);
                    Utils.swap(users, i, i - amount);
                    for (j = i - amount; j >= 0 && Utils.compare(x, users.get(j)); j = j - amount) {//通过循环，逐个后移一位找到要插入的位置。
                        Utils.swap(users, j + amount, j);
                    }
                    Utils.swap(users, j + amount, i);
                }

            }
            amount = amount / 2;
        }
    }


}
