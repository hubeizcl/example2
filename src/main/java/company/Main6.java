package company;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main6 {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        pool.execute(() -> System.out.println("Asynchronous task"));
        pool.shutdown();
    }
}
