package com.zcl.designpatterns.structuraltype;

/**
 * @Author :zhangchenglong
 * @Date :2018年 05月15日17时00分
 * @Description :
 */
public class AdapterModel {
    public static void main(String[] args) {
        Target target = new Adapter(new Adaptee());
        target.adapteeMethod();
        target.adapterMethod();
    }

}

interface Target {
    void adapteeMethod();

    void adapterMethod();
}

class Adaptee {
    public void adapteeMethod() {
        System.out.println("Adaptee method!");
    }
}

class Adapter implements Target {

    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void adapteeMethod() {
        adaptee.adapteeMethod();
    }

    @Override
    public void adapterMethod() {
        System.out.println("Adapter method!");
    }
}