package com.zcl.sorted;

import java.util.List;

public class SortedDirectly {
    public static void sortedDirectly(List<User> objs) {
        for (int i = 1; i < objs.size(); i++) {           //从头部第一个当做已经排好序的，把后面的一个一个的插到已经排好的列表中去。
            User x = objs.get(i);//x为待插入元素
            int j;
            for (j = i; j > 0 && Utils.compare(x, objs.get(j - 1)); j--) {
                Utils.swap(objs, j, j - 1);
            }
        }

    }


}


