package com.zcl.designpatterns.action;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author :zhangchenglong
 * @Date :2018年 05月16日09时33分
 * @Description :解释器模式 给定一个语言，定义它的文法的一种表示，并定义一个解释器，这个解释器使用该表示来解释语言中的句子。
 */
public class InterpreterModel {
    public static void main(String[] args) {
        Context context = new Context();
        context.add(new SimpleExpression());
        context.add(new AdvanceExpression());
        context.add(new SimpleExpression());
        context.getList().forEach(e -> e.interpret(context));
    }
}

class Context {
    private String content;
    private List<Expression> list = new ArrayList();

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Expression> getList() {
        return list;
    }

    public void add(Expression expression) {
        this.list.add(expression);
    }
}

abstract class Expression {
    abstract void interpret(Context ctx);
}

class AdvanceExpression extends Expression {
    @Override
    void interpret(Context ctx) {
        System.out.println("这是高级解析器!");
    }
}

class SimpleExpression extends Expression {
    @Override
    void interpret(Context ctx) {
        System.out.println("这是普通解析器!");
    }
}
