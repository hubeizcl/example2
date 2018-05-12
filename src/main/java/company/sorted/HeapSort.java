package company.sorted;

import java.util.ArrayList;
import java.util.List;

public class HeapSort {

    public static void heapSort(List<User> users) {
        for (int i = 0; i < users.size(); i++) {
            createLittleHeap2(users, users.size() - 1 - i);//创建堆,创建的是小顶堆。每次循环完，二叉树的根节点都是最小值，所以与此时的未排好部分最后一个值交换位置
            Utils.swap(users, 0, users.size() - 1 - i);//与最后一个值交换位置，最小值找到了位置
        }
    }


    private static void createLittleHeap2(List<User> users, int last) {
        for (int i = last; i > 0; i--) {
            int parent = (i - 1) / 2;//当前节点的双亲节点
            if (Utils.compare(users.get(parent), users.get(i)))
                Utils.swap(users, parent, i);
        }
    }

    /*
   * 创建小顶堆：双亲节点小于子节点的值。从叶子节点开始，直到根节点。这样建立的堆定位最小值
   */
    private static void createLittleHeap(List<User> users, int last) {
        for (int i = (last - 1) / 2; i >= 0; i--) {  //找到最后一个叶子节点的双亲节点
            // 保存当前正在判断的节点
            int parent = i;
            // 若当前节点的左子节点存在，即子节点存在
            while (2 * parent + 1 <= last) {
                // biggerIndex总是记录较大节点的值,先赋值为当前判断节点的左子节点
                int bigger = 2 * parent + 1;//bigger指向左子节点
                if (bigger < last) { //说明存在右子节点
                    if (Utils.compare(users.get(bigger), users.get(bigger + 1))) { //右子节点>左子节点时
                        bigger = bigger + 1;
                    }
                }
                if (Utils.compare(users.get(parent), users.get(bigger))) {  //若双亲节点值大于子节点中最大的
                    // 若当前节点值比子节点最大值小，则交换2者得值，交换后将biggerIndex值赋值给k
                    Utils.swap(users, parent, bigger);
                    parent = bigger;
                } else {
                    break;
                }
            }
        }
    }

    public static List<User> GetLeastNumbers_Solution(List<User> users, int k) {
        List<User> result = new ArrayList<>();
        if (k > users.size()) return result;
        for (int i = 0; i < k; i++) {//只排前k次
            heapSort(users, i, users.size());//进行第i次排序
            result.add(users.get(i));
        }
        return result;
    }

    private static void heapSort(List<User> users, int root, int end) {//小顶堆实现
        for (int j = end - 1; j >= root; j--) {
            int parent = (j + root - 1) / 2;//算出j节点的双亲节点的序号
            if (Utils.compare(users.get(parent), users.get(j))) {//双亲节点大于当前节点，交换位置。
                Utils.swap(users, parent, j);
            }
        }
    }


}
