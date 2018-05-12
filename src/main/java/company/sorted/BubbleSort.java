package company.sorted;

import java.util.List;

public class BubbleSort {

    public static void bubbleSort(List<User> users) {
        for (int i = 0; i < users.size() - 1; ++i) {
            for (int j = 0; j < users.size() - i - 1; ++j) {
                if (Utils.compare(users, j, j + 1)) {
                    Utils.swap(users, j, j + 1);
                }
            }
        }
    }

    public static void Bubble_1(List<User> users) {
        int i = users.size() - 1;  //初始时,最后位置保持不变
        while (i > 0) {
            int pos = 0; //每趟开始时,无记录交换
            for (int j = 0; j < i; j++)
                if (Utils.compare(users, j, j + 1)) {
                    pos = j; //记录交换的位置
                    Utils.swap(users, j, j + 1);
                }
            i = pos; //为下一趟排序作准备
        }
    }

    public static void Bubble_2(List<User> users) {
        int low = 0;
        int high = users.size() - 1;                    //设置变量的初始值
        int j;
        while (low < high) {
            for (j = low; j < high; ++j)                //正向冒泡,找到最大者
                if (Utils.compare(users, j, j + 1)) {
                    Utils.swap(users, j, j + 1);
                }
            --high;                                     //修改high值, 前移一位
            for (j = high; j > low; --j)                //反向冒泡,找到最小者
                if (Utils.compare(users, j, j - 1)) {
                    Utils.swap(users, j, j - 1);
                }
            ++low;                                      //修改low值,后移一位
        }
    }
}
