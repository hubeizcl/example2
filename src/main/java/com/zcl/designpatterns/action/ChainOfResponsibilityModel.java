package com.zcl.designpatterns.action;

/**
 * @Author :zhangchenglong
 * @Date :2018年 05月16日09时33分
 * @Description :责任链模式 责任链模式的定义：使多个对象都有机会处理请求，从而避免请求的发送者和接受者之间的耦合关系， 将这个对象连成一条链，并沿着这条链传递该请求，直到有一个对象处理他为止。这里就不再过多的介绍什么是责任链模式，主要来说说java中如何编写。主要从下面3个框架中的代码中介绍。
 */
public class ChainOfResponsibilityModel {
    public static void main(String[] args) {
        RequestHandle hr = new HRRequestHandle();
        RequestHandle pm = new PMRequestHandle(hr);
        RequestHandle tl = new TLRequestHandle(pm);
        //team leader处理离职请求
        Request request = new DimissionRequest();
        tl.handleRequest(request);

        System.out.println("===========");
        //team leader处理加薪请求
        request = new AddMoneyRequest();
        tl.handleRequest(request);

        System.out.println("========");
        //项目经理上理辞职请求
        request = new DimissionRequest();
        pm.handleRequest(request);
    }

}


class DimissionRequest extends Request {
}

class AddMoneyRequest extends Request {
}

class LeaveRequest extends Request {
}

interface RequestHandle {
    void handleRequest(Request request);
}

class Request {
}

class HRRequestHandle implements RequestHandle {
    @Override
    public void handleRequest(Request request) {
        if (request instanceof DimissionRequest) {
            System.out.println("要离职, 人事审批!");
        }
        System.out.println("请求完");
    }
}

class PMRequestHandle implements RequestHandle {
    RequestHandle requestHandle;

    public PMRequestHandle(RequestHandle requestHandle) {
        this.requestHandle = requestHandle;
    }

    @Override
    public void handleRequest(Request request) {
        if (request instanceof AddMoneyRequest) {
            System.out.println("要加薪, 项目经理审批!");
        } else {
            requestHandle.handleRequest(request);
        }
    }
}

class TLRequestHandle implements RequestHandle {

    RequestHandle requestHandle;

    public TLRequestHandle(RequestHandle requestHandle) {
        this.requestHandle = requestHandle;
    }

    @Override
    public void handleRequest(Request request) {
        if (request instanceof LeaveRequest) {
            System.out.println("要请假, 项目组长审批!");
        } else {
            requestHandle.handleRequest(request);
        }
    }
}


