package com.zcl.designpatterns.action;

/**
 * @Author :zhangchenglong
 * @Date :2018年 05月16日09时34分
 * @Description :中介者模式 用一个中介对象来封装一系列的对象交互。中介者使各对象不需要显式地相互引用，从而使其耦合松散，而且可以独立地改变它们之间的交互。
 */
public class MediatorModel {
    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();
        mediator.notice("boss");
        mediator.notice("client");
    }
}

abstract class Mediator {

    public abstract void notice(String content);
}

class ConcreteMediator extends Mediator {

    private ColleagueA ca;
    private ColleagueB cb;

    public ConcreteMediator() {
        this.ca = new ColleagueA();
        this.cb = new ColleagueB();
    }

    @Override
    public void notice(String content) {
        if (content.equals("boss")) {
            ca.action();
        }
        if (content.equals("client")) {
            cb.action();
        }
    }

}

class ColleagueA {
    public void action() {
        System.out.println("普通员工努力工作");
    }
}

class ColleagueB {
    public void action() {
        System.out.println("前台注意了!");
    }
}
