package company.sorted;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Main33 {


    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
//        test4();
//        test5();
        test6();
    }

    private static void test6() {
        List<User> list = createList();
        QuickSort.sort(list, 0, list.size() - 1);
        list.forEach(user -> System.out.println(user));
    }

    private static void test5() {
        List<User> list = createList();
        BubbleSort.bubbleSort(list);
        list.forEach(user -> System.out.println(user));
        System.out.println("-----------------------");
        List<User> list2 = createList();
        BubbleSort.Bubble_1(list2);
        list2.forEach(user -> System.out.println(user));
        System.out.println("-----------------------");
        List<User> list3 = createList();
        BubbleSort.Bubble_2(list2);
        list3.forEach(user -> System.out.println(user));
    }

    private static void test4() {
        List<User> list = createList();
        HeapSort.heapSort(list);
        List<User> users = HeapSort.GetLeastNumbers_Solution(list, 4);
        list.forEach(user -> System.out.println(user));
        System.out.println("-----------------------");
        users.forEach(user -> System.out.println(user));
    }

    private static void test3() {
        List<User> list = createList();
//        SimpleSelectSort.SimpleSelectSort(list);
        SimpleSelectSort.SelectSort(list);
        list.forEach(user -> System.out.println(user));
    }

    private static void test2() {
        List<User> list = createList();
        ShellSorting.shellSorting(list);
        list.forEach(user -> System.out.println(user));
    }

    private static void test1() {
        List<User> list = createList();
        SortedDirectly.sortedDirectly(list);
        list.forEach(user -> System.out.println(user));
    }

    private static List<User> createList() {
        List<User> users = new ArrayList<>();
        User user1 = new User("tom", 27);
        User user2 = new User("lili", 25);
        User user3 = new User("mali", 30);
        User user4 = new User("lilei", 15);
        User user5 = new User("xixi", 8);
        User user6 = new User("xiaoming", 86);
        User user7 = new User("xiali", 65);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);
        users.add(user7);
        return users;
    }
}


class User {
    private String id;
    private String name;
    private Integer age;
    private Character sex;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }


    public User(String id, String name, Integer age, Character sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Character getSex() {
        return sex;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
