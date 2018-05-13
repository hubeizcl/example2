package com.zcl;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main8 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Set<Callable<String>> callables = new HashSet<>();
        callables.add(() -> {
            return "task 1";
        });
        callables.add(() -> {
            return "task 2";
        });
        callables.add(() -> {
            return "task 3";
        });
        String invokeAny = executorService.invokeAny(callables);
        executorService.invokeAll(callables).forEach(future -> {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        System.out.println(invokeAny);
        executorService.shutdown();

    }
}
