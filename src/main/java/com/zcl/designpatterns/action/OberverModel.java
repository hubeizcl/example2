package com.zcl.designpatterns.action;

import java.util.ArrayList;

/**
 * @Author :zhangchenglong
 * @Date :2018年 05月16日09时35分
 * @Description :观察者模式   定义对象间的一种一*多的依赖关系,当一个对象的状态发生改变时,所有依赖于它的对象都得到通知并被自动更新。
 */
public class OberverModel {
    public static void main(String[] args) {
        Policeman thPol = new TianHePoliceman();
        Policeman hpPol = new HuangPuPoliceman();

        Citizen citizen = new HuangPuCitizen(hpPol);
        citizen.sendMessage("unnormal");
        citizen.sendMessage("normal");

        System.out.println("===========");

        citizen = new TianHeCitizen(thPol);
        citizen.sendMessage("normal");
        citizen.sendMessage("unnormal");
    }
}

abstract class Citizen {

    ArrayList<Policeman> pols;

    String help = "normal";

    abstract void sendMessage(String help);

    public void setPolicemen() {
        this.pols = new ArrayList<>();
    }

    public void register(Policeman pol) {
        this.pols.add(pol);
    }

    public void unRegister(Policeman pol) {
        this.pols.remove(pol);
    }

    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help;
    }

}

interface Policeman {
    void action(Citizen citizen);
}

class HuangPuCitizen extends Citizen {
    public HuangPuCitizen(Policeman pol) {
        setPolicemen();
        register(pol);
    }

    @Override
    void sendMessage(String help) {
        setHelp(help);
        for (int i = 0; i < pols.size(); i++) {
            pols.get(i).action(this);
        }
    }
}

class TianHeCitizen extends Citizen {
    public TianHeCitizen(Policeman pol) {
        setPolicemen();
        register(pol);
    }

    @Override
    void sendMessage(String help) {
        setHelp(help);
        for (int i = 0; i < pols.size(); i++) {
            pols.get(i).action(this);
        }
    }
}

class HuangPuPoliceman implements Policeman {
    @Override
    public void action(Citizen citizen) {
        String help = citizen.getHelp();
        if (help.equals("normal")) {
            System.out.println("一切正常, 不用出动");
        }
        if (help.equals("unnormal")) {
            System.out.println("有犯罪行为, 黄埔警察出动!");
        }
    }
}

class TianHePoliceman implements Policeman {
    @Override
    public void action(Citizen citizen) {
        String help = citizen.getHelp();
        if (help.equals("normal")) {
            System.out.println("一切正常, 不用出动");
        }
        if (help.equals("unnormal")) {
            System.out.println("有犯罪行为, 天河警察出动!");
        }
    }
}
