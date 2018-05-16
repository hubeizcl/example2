package com.zcl.designpatterns.action;


/**
 * @Author :zhangchenglong
 * @Date :2018年 05月16日09时34分
 * @Description :迭代器*式   给定一个语言，定义它的文法的一种表示，并定义一个解释器，这个解释器使用该表示来解释语言中的句子。
 */
public class IteratorModel {
    public static void main(String[] args) {
        List list = new ListImpl();
        list.add("a");
        list.add("b");
        list.add("c");
        //第一种迭代方式
        Iterator it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println("=====");
        //第二种迭代方式
        for (int i = 0; i < list.getSize(); i++) {
            System.out.println(list.get(i));
        }
    }
}

interface Iterator {
    Object next();

    void first();

    void last();

    boolean hasNext();
}

interface List {
    Iterator iterator();

    Object get(int index);

    int getSize();

    void add(Object obj);

}

class ListImpl implements List {
    private Object[] list;
    private int index;
    private int size;

    public ListImpl() {
        list = new Object[100];
        index = 0;
        size = 0;
    }

    @Override
    public Iterator iterator() {
        return new IteratorImpl(this);
    }

    @Override
    public Object get(int index) {
        return list[index];
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public void add(Object obj) {
        list[index++] = obj;
        size++;
    }
}

class IteratorImpl implements Iterator {
    private List list;
    private int index;

    public IteratorImpl(List list) {
        this.list = list;
        this.index = 0;
    }

    @Override
    public Object next() {
        Object o = list.get(index);
        index++;
        return o;
    }

    @Override
    public void first() {
        index = 0;
    }

    @Override
    public void last() {
        index = list.getSize();
    }

    @Override
    public boolean hasNext() {
        return index < list.getSize();
    }
}
