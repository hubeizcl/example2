package com.zcl.designpatterns.structuraltype;

/**
 * @Author :zhangchenglong
 * @Date :2018年 05月15日17时28分
 * @Description :
 */
public class DecorationModel {
    public static void main(String[] args) {
        Man2 man2 = new Man2();
        ManDecoratorA manDecoratorA = new ManDecoratorA();
        ManDecoratorB manDecoratorB = new ManDecoratorB();
        manDecoratorA.setPerson2(man2);
        manDecoratorB.setPerson2(man2);
        manDecoratorA.eat();
        manDecoratorB.eat();
    }
}

class ManDecoratorB extends Decorator {
    @Override
    public void eat() {
        super.eat();
        System.out.println("===============");
        System.out.println("ManDecoratorB类");
    }
}

class ManDecoratorA extends Decorator {
    @Override
    public void eat() {
        super.eat();
        reEat();
        System.out.println("ManDecoratorA类");
    }

    private void reEat() {
        System.out.println("再吃一顿饭");
    }
}

abstract class Decorator implements Person2 {
    protected Person2 person2;

    public void setPerson2(Person2 person2) {
        this.person2 = person2;
    }

    @Override
    public void eat() {
        person2.eat();
    }
}

interface Person2 {
    public void eat();
}

class Man2 implements Person2 {
    @Override
    public void eat() {
        System.out.println("男人在吃");
    }
}