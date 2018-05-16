package com.zcl.designpatterns.structuraltype;

/**
 * @Author :zhangchenglong
 * @Date :2018年 05月16日09时27分
 * @Description :
 */
public class ProxyModel {
    public static void main(String[] args) {
        ProxyObject proxyObject = new ProxyObject();
        proxyObject.action();
    }
}

interface Object {
    void action();
}

class ObjectImpl implements Object {
    @Override
    public void action() {
        System.out.println("========");
        System.out.println("========");
        System.out.println("这是被代理的类");
        System.out.println("========");
        System.out.println("========");
    }
}

class ProxyObject implements Object {
    Object object;

    public ProxyObject() {
        System.out.println("这是代理类");
        this.object = new ObjectImpl();
    }

    @Override
    public void action() {
        System.out.println("代理开始");
        object.action();
        System.out.println("代理结束");
    }
}
