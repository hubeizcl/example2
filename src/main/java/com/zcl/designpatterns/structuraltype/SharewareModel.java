package com.zcl.designpatterns.structuraltype;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author :zhangchenglong
 * @Date :2018年 05月16日09时13分
 * @Description :
 */
public class SharewareModel {
    public static void main(String[] args) {
        Flyweight a = FlyweightFactory.getFlyweights("a");
        a.action(1);
        Flyweight a1 = FlyweightFactory.getFlyweights("a");
        System.out.println(a == a1);
        FlyweightFactory.getFlyweights("b").action(2);
        FlyweightFactory.getFlyweights("c").action(3);
        FlyweightFactory.getFlyweights("d").action(4);
    }
}

interface Flyweight {
    void action(int arg);
}

class FlyweightImpl implements Flyweight {
    @Override
    public void action(int arg) {
        System.out.println("参数值: " + arg);
    }
}

class FlyweightFactory {
    private static Map<String, Flyweight> flyweights = new HashMap<>();

    public FlyweightFactory(String arg) {
        flyweights.put(arg, new FlyweightImpl());
    }

    public static Flyweight getFlyweights(String key) {
        if (flyweights.get(key) == null) {
            flyweights.put(key, new FlyweightImpl());
        }
        return flyweights.get(key);
    }

    public static int getSize() {
        return flyweights.size();
    }

}
