package com.zcl.designpatterns.builder;

/**
 * @Author :zhangchenglong
 * @Date :2018年 05月15日15时58分
 * @Description :
 */
public class FactoryModel {
    public static void main(String[] args) {
        new StudentWorkFactory().getWork().doWork();
        new TeacherWorkFactory().getWork().doWork();
    }
}

interface Work {
    void doWork();
}

class StudentWork implements Work {
    public void doWork() {
        System.out.println("学生*作业!");
    }
}

class TeacherWork implements Work {
    @Override
    public void doWork() {
        System.out.println("老师审批作业!");
    }
}


interface IWorkFactory {
    Work getWork();
}

class StudentWorkFactory implements IWorkFactory {
    @Override
    public Work getWork() {
        return new StudentWork();
    }
}

class TeacherWorkFactory implements IWorkFactory {
    public Work getWork() {
        return new TeacherWork();
    }

}