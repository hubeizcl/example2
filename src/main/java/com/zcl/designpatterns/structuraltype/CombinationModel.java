package com.zcl.designpatterns.structuraltype;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author :zhangchenglong
 * @Date :2018年 05月15日17时14分
 * @Description :
 */
public class CombinationModel {
    public static void main(String[] args) {
        ProjectManager manager = new ProjectManager("项目经理");
        ProjectAssistant assistant = new ProjectAssistant("项目助理");
        Programmer programmer1 = new Programmer("程序员一");
        Programmer programmer2 = new Programmer("程序员二");
        manager.add(assistant);
        manager.add(programmer1);
        manager.add(programmer2);
        List employers = manager.getEmployers();
        employers.forEach(e -> System.out.println(((Employer) e).getName()));
    }
}

class Programmer extends Employer {

    public Programmer(String name) {
        this.setName(name);
        employers = null;
    }

    @Override
    public void add(Employer employer) {

    }

    @Override
    public void delete(Employer employer) {

    }
}

class ProjectManager extends Employer {

    public ProjectManager(String name) {
        this.setName(name);
        employers = new ArrayList();
    }

    @Override
    public void add(Employer employer) {
        employers.add(employer);
    }

    @Override
    public void delete(Employer employer) {
        employers.remove(employer);
    }
}

class ProjectAssistant extends Employer {

    public ProjectAssistant(String name) {
        this.setName(name);
        employers = null;
    }

    @Override
    public void add(Employer employer) {

    }

    @Override
    public void delete(Employer employer) {

    }
}

abstract class Employer {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void add(Employer employer);

    public abstract void delete(Employer employer);

    public List employers;

    public void printInfo() {
        System.out.println(name);
    }

    public List getEmployers() {
        return this.employers;
    }

}


