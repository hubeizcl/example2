package com.zcl.designpatterns.builder;

/**
 * @Author :zhangchenglong
 * @Date :2018年 05月15日16时20分
 * @Description :
 */
public class BuilderModel {
    public static void main(String[] args) {
        ManBulider bulider = new ManBulider();
        bulider.buildBody();
        bulider.buildFoot();
        bulider.buildHead();
        Person person = bulider.buildPerson();
        System.out.println(person);
    }
}

interface PersonBuilder {
    void buildHead();
    void buildBody();
    void buildFoot();
    Person buildPerson();
}

class ManBulider implements PersonBuilder {

    Person person;

    public ManBulider() {
        person = new Man();
    }

    @Override
    public void buildHead() {
        person.setHead("建造男人的头");
    }

    @Override
    public void buildBody() {
        person.setBody("建造男人的脚");
    }

    @Override
    public void buildFoot() {
        person.setFoot("建造男人的头");
    }

    @Override
    public Person buildPerson() {
        return person;
    }
}

class Man extends Person {
}

class Person {
    private String head;
    private String body;
    private String foot;

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getFoot() {
        return foot;
    }

    public void setFoot(String foot) {
        this.foot = foot;
    }

    @Override
    public String toString() {
        return "Person{" +
                "head='" + head + '\'' +
                ", body='" + body + '\'' +
                ", foot='" + foot + '\'' +
                '}';
    }
}
