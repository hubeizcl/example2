package company;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class Main21 {

    public static class Counter {

        private volatile int count = 0;

        public void inc() throws InterruptedException {
            Thread.sleep(1000);
            count++;
        }

        @Override
        public String toString() {
            return "[count=" + count + "]";
        }
    }

    public static Stream<Long> range(Long index, Long length, Long step) {
        return Stream.generate(() -> {
            Long next = index;
            next += step;
            return next;
        }).limit(length);
    }

    public static void main(String[] args) {
        Counter counter = new Counter();
        ExecutorService executorService = Executors.newCachedThreadPool();
        range(0L, 1000L, 1L).forEach(i -> {
            executorService.execute(new Thread(() -> {
                try {
                    counter.inc();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }));
        });

        try {
            executorService.awaitTermination(20, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(counter);
    }
}
