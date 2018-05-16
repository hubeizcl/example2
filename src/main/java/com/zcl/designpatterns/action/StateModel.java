package com.zcl.designpatterns.action;

/**
 * @Author :zhangchenglong
 * @Date :2018年 05月16日09时35分
 * @Description :状态模式   定义对象间*一种一对多的依赖关系,当一个对象的状态*生改变时,所*依赖于它的对象都得到通知并被自动更新。
 */
public class StateModel {
    public static void main(String[] args) {
        Context2 context2 = new Context2();
        context2.setWeather(new Sunshine());
        System.out.println(context2.weatherMessage());
        Context2 context3 = new Context2();
        context3.setWeather(new Rain());
        System.out.println(context3.weatherMessage());
    }
}

class Sunshine implements Weather {
    @Override
    public String getWeather() {
        return "阳光";
    }
}

class Rain implements Weather {
    @Override
    public String getWeather() {
        return "下雨";
    }
}

interface Weather {
    String getWeather();
}

class Context2 {

    private Weather weather;

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public String weatherMessage() {
        return weather.getWeather();
    }
}