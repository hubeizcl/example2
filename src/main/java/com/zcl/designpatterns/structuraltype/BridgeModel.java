package com.zcl.designpatterns.structuraltype;

/**
 * @Author :zhangchenglong
 * @Date :2018年 05月15日17时05分
 * @Description :
 */
public class BridgeModel {
    public static void main(String[] args) {
        Man man = new Man();
        Woman woman = new Woman();
        Jacket jacket = new Jacket();
        Trouser trouser = new Trouser();
        jacket.personDressCloth(man);
        jacket.personDressCloth(woman);
        trouser.personDressCloth(man);
        trouser.personDressCloth(woman);
    }
}

class Woman extends Person {

    public Woman() {
        this.setType("女人");
    }

    @Override
    public void dress() {
        Clothing clothing = this.getClothing();
        clothing.personDressCloth(this);
    }
}

class Man extends Person {
    public Man() {
        this.setType("男人");
    }

    @Override
    public void dress() {
        Clothing clothing = getClothing();
        clothing.personDressCloth(this);
    }
}

abstract class Person {
    private Clothing clothing;

    private String type;

    public Clothing getClothing() {
        return clothing;
    }

    public void setClothing(Clothing clothing) {
        this.clothing = clothing;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public abstract void dress();

}

abstract class Clothing {
    public abstract void personDressCloth(Person person);
}

class Jacket extends Clothing {
    @Override
    public void personDressCloth(Person person) {
        System.out.println(person.getType() + "穿马甲");
    }
}

class Trouser extends Clothing {
    @Override
    public void personDressCloth(Person person) {
        System.out.println(person.getType() + "穿裤子");
    }
}
