package company;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main15 {

    private final static ThreadLocal<String> local = new ThreadLocal<>();

    private static String courtUUID = " ";

    public static String getCourtUUID(ThreadLocal<String> local) {
        return local.get();
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            service.submit(()->{
                local.set("");
                System.out.println(getCourtUUID(local));
            });
        }
    }

}
