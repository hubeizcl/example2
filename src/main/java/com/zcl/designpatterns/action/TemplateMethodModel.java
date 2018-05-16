package com.zcl.designpatterns.action;

/**
 * @Author :zhangchenglong
 * @Date :2018年 05月16日09时36分
 * @Description :模板方法   定义*个操作中的算法的骨架，*将一些步骤延迟到子类中。
 */
public class TemplateMethodModel {
    public static void main(String[] args) {
        TemplateConcrete templateConcrete = new TemplateConcrete();
        templateConcrete.update();
    }
}


abstract class Template {
    abstract void print();

    public void update() {
        System.out.println("开始打印");
        for (int i = 0; i < 10; i++) {
            print();
        }
    }
}

class TemplateConcrete extends Template {
    @Override
    void print() {
        System.out.println("这是子类的实现");
    }
}