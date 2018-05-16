package com.zcl.designpatterns.structuraltype;

/**
 * @Author :zhangchenglong
 * @Date :2018年 05月15日17时59分
 * @Description :
 */
public class FacadeModel {
    public static void main(String[] args) {
        ServiceA serviceA = new ServiceAImpl();
        ServiceB serviceB = new ServiceBImpl();
        serviceA.methodA();
        serviceB.methodB();

        System.out.println("==============");
        Facade facade = new Facade();
        facade.methodA();
        facade.methodB();
    }
}

class Facade {

    ServiceA sa;

    ServiceB sb;

    ServiceC sc;

    public Facade() {
        sa = new ServiceAImpl();
        sb = new ServiceBImpl();
        sc = new ServiceCImpl();
    }

    public void methodA() {
        sa.methodA();
        sb.methodB();
    }

    public void methodB() {
        sb.methodB();
        sc.methodC();
    }

    public void methodC() {
        sc.methodC();
        sa.methodA();
    }
}

abstract class ServiceA {
    public abstract void methodA();
}

abstract class ServiceB {
    public abstract void methodB();
}

abstract class ServiceC {
    public abstract void methodC();
}


class ServiceAImpl extends ServiceA {
    public void methodA() {
        System.out.println("这是服务A");
    }
}

class ServiceBImpl extends ServiceB {
    public void methodB() {
        System.out.println("这是服务B");
    }
}

class ServiceCImpl extends ServiceC {
    public void methodC() {
        System.out.println("这是服务C");
    }
}
