package com.zcl.designpatterns.builder;

/**
 * @Author :zhangchenglong
 * @Date :2018年 05月15日16时37分
 * @Description :
 */
public class SingletonModel {
    public static void main(String[] args) {
        Tom tomInstance = Tom.getTomInstance();
        Tom tomInstance1 = Tom.getTomInstance();
        System.out.println(tomInstance == tomInstance1);
    }
}

class Tom {
    private static Tom tom;

    private Tom() {
    }

    public static Tom getTomInstance() {
        if (null == tom) {
            tom = new Tom();
        }
        return tom;
    }
}