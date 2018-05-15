package com.zcl.designpatterns.builder;

/**
 * @Author :zhangchenglong
 * @Date :2018年 05月15日16时43分
 * @Description :
 */
public class ProtypeModel {
    public static void main(String[] args) {
        TwinBrother tom = new TwinBrother("tom");
        TwinBrother tom2 = (TwinBrother) tom.clone();
        System.out.println(tom==tom2);
    }
}

class TwinBrother extends BuilderPerson {

    public TwinBrother(String name) {
        this.setName(name);
    }

}


class BuilderPerson implements Cloneable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}

