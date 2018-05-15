package com.zcl.designpatterns.builder;

/**
 * @Author :zhangchenglong
 * @Date :2018年 05月15日16时11分
 * @Description :
 */
public class AbstractFactoryModel {
    public static void main(String[] args) {
        IAnimalFactory blackAnimalFactory = new BlackAnimalFactory();
        ICat blackCat = blackAnimalFactory.createCat();
        blackCat.eat();
        IDog blackDog = blackAnimalFactory.createDog();
        blackDog.eat();

        IAnimalFactory whiteAnimalFactory = new WhiteAnimalFactory();
        ICat whiteCat = whiteAnimalFactory.createCat();
        whiteCat.eat();
        IDog whiteDog = whiteAnimalFactory.createDog();
        whiteDog.eat();
    }
}


interface IAnimalFactory {
    ICat createCat();
    IDog createDog();
}

class BlackAnimalFactory implements IAnimalFactory {
    public ICat createCat() {
        return new BlackCat();
    }

    public IDog createDog() {
        return new BlackDog();
    }

}

class WhiteAnimalFactory implements IAnimalFactory {
    public ICat createCat() {
        return new WhiteCat();
    }

    public IDog createDog() {
        return new WhiteDog();
    }
}


interface ICat {
    void eat();
}

interface IDog {
    void eat();
}


class BlackCat implements ICat {
    public void eat() {
        System.out.println("The bl*ck cat is eating!");
    }

}

class WhiteCat implements ICat {
    public void eat() {
        System.out.println("The write cat is eating!");
    }

}

class BlackDog implements IDog {
    public void eat() {
        System.out.println("The black dog is eating");
    }

}

class WhiteDog implements IDog {
    public void eat() {
        System.out.println("The white dog is eat*ng!");
    }

}


