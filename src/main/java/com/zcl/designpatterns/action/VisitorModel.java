package com.zcl.designpatterns.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @Author :zhangchenglong
 * @Date :2018年 05月16日09时37分
 * @Description :访问者模式 表*一个作用于某对象结构中的各元素的操作。
 * 它使你可以在不改变各元素的类的前提下定义作用于这些元素的新操作。
 */
public class VisitorModel {
    public static void main(String[] args) {
        Visitor visitor = new ConcreteVisitor();
        StringElement stringElement = new StringElement("abc");
        stringElement.accept(visitor);
        FloatElement floatElement = new FloatElement(Float.valueOf(1.5f));
        floatElement.accept(visitor);
        System.out.println("===================");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new StringElement("abc"));
        arrayList.add(new StringElement("abc"));
        arrayList.add(new StringElement("abc"));
        arrayList.add(new StringElement("abc"));
        arrayList.add(new FloatElement(Float.valueOf(1.5f)));
        arrayList.add(new FloatElement(Float.valueOf(1.5f)));
        arrayList.add(new FloatElement(Float.valueOf(1.5f)));
        arrayList.add(new FloatElement(Float.valueOf(1.5f)));
        visitor.visitCollection(arrayList);
    }
}

class ConcreteVisitor implements Visitor {
    @Override
    public void visitString(StringElement stringE) {
        System.out.println(stringE.getSe());
    }

    @Override
    public void visitFloat(FloatElement floatE) {
        System.out.println(floatE.getFe());
    }

    @Override
    public void visitCollection(Collection collection) {
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            if (next instanceof Visitable) {
                ((Visitable) next).accept(this);
            }
        }
    }
}

interface Visitable {
    public void accept(Visitor visitor);
}


interface Visitor {
    void visitString(StringElement stringE);

    void visitFloat(FloatElement floatE);

    void visitCollection(Collection collection);
}

class StringElement implements Visitable {

    private String se;

    public StringElement(String se) {
        this.se = se;
    }

    public String getSe() {
        return se;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitString(this);
    }
}

class FloatElement implements Visitable {

    private Float fe;

    public FloatElement(Float fe) {
        this.fe = fe;
    }

    public Float getFe() {
        return fe;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitFloat(this);
    }
}