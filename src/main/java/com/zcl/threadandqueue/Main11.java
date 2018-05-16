package com.zcl.threadandqueue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class Main11 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        ForkJoinPool forkJoinPool = new ForkJoinPool(4);
        forkJoinPool.invoke(new MyRecursiveAction(24L));


    }
}

class MyRecursiveAction extends RecursiveAction {

    private Long workLoad = 0L;

    public MyRecursiveAction(Long workLoad) {
        this.workLoad = workLoad;
    }

    @Override
    protected void compute() {
        if (this.workLoad > 16) {
            System.out.println("Splitting workLoad : " + this.workLoad);
            ArrayList<MyRecursiveAction> subtasks = new ArrayList<>();
            subtasks.addAll(createSubtasks());
            subtasks.forEach(subtask -> subtask.fork());
        } else {
            System.out.println("Doing workLoad myself: " + this.workLoad);
        }
    }

    private Collection<? extends MyRecursiveAction> createSubtasks() {
        List<MyRecursiveAction> subtasks = new ArrayList<MyRecursiveAction>();
        subtasks.add(new MyRecursiveAction(this.workLoad / 2));
        subtasks.add(new MyRecursiveAction(this.workLoad / 2));
        return subtasks;
    }
}