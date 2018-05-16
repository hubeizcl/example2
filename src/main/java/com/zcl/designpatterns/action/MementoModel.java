package com.zcl.designpatterns.action;

/**
 * @Author :zhangchenglong
 * @Date :2018年 05月16日09时35分
 * @Description :备忘录模式  在不破坏封装性*前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态。这样以后就可将该对象恢复到原先保存的状态。
 */
public class MementoModel {
    public static void main(String[] args) {
        Originator originator = new Originator();
        originator.setState("开会中");
        Caretaker caretaker = new Caretaker();
        caretaker.setMemento(originator.getMemento());
        originator.setState("睡觉中");
        originator.showState();
        originator.setMemento(caretaker.getMemento());
        originator.showState();

    }
}

class Caretaker {
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}

class Originator {
    private String state;

    public Memento getMemento() {
        return new Memento(state);
    }

    public void setMemento(Memento memento) {
        state = memento.getState();
    }

    public void showState() {
        System.out.println(state);
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
