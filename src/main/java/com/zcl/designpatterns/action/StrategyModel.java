package com.zcl.designpatterns.action;

/**
 * @Author :zhangchenglong
 * @Date :2018年 05月16日09时36分
 * @Description :策略模式 定义一系列的算法,把它们*个个封装起来,并且使它们可相互替换。本模式使得算法可独立于使用它的客户而变化。
 */
public class StrategyModel {
    public static void main(String[] args) {
        Context3 context3 = new Context3(new StrategyImplA());
        context3.doMethod();
        context3 = new Context3(new StrategyImplB());
        context3.doMethod();
        context3 = new Context3(new StrategyImplC());
        context3.doMethod();
    }
}

class Context3 {
    Strategy stra;

    public Context3(Strategy stra) {
        this.stra = stra;
    }

    public void doMethod() {
        stra.method();
    }
}

abstract class Strategy {
    abstract void method();
}

class StrategyImplA extends Strategy {
    @Override
    void method() {
        System.out.println("这是第一个实现");
    }
}

class StrategyImplB extends Strategy {
    @Override
    void method() {
        System.out.println("这是第二个实现");
    }
}

class StrategyImplC extends Strategy {
    @Override
    void method() {
        System.out.println("这是第三个实现");
    }
}