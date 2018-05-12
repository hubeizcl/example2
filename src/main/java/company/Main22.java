package company;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Main22 {
    static Semaphore semaphore = new Semaphore(5, true);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Main21.range(0L, 100L, 1L).forEach(i -> {
            executorService.execute(new Thread(Main22::run));
        });
        executorService.shutdown();

    }

    private static void run() {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "进来了");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "走了");
        semaphore.release();
    }
}
