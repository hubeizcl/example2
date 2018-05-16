package com.zcl.designpatterns.action;

/**
 * @Author :zhangchenglong
 * @Date :2018年 05月16日09时33分
 * @Description :命令模式 将一个请求封装为一个对象，从而使你可用不同的请求对客户进行参数化；对请求排队或记录请求日志，以及支持可撤消的*作
 */
public class CommandModel {
    public static void main(String[] args) {
        Receiver rec = new Receiver();
        Command cmd = new CommandImpl(rec);
        Invoker i = new Invoker();
        i.setCommand(cmd);
        i.execute();
    }
}

class Receiver {
    public void receive() {
        System.out.println("This is Receive class!");
    }
}

abstract class Command {

    protected Receiver receiver;

    public Command(Receiver receiver) {
        this.receiver = receiver;
    }

    public abstract void execute();
}

class CommandImpl extends Command {
    public CommandImpl(Receiver receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        receiver.receive();
    }
}

class Invoker {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void execute() {
        command.execute();
    }
}

