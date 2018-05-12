package company;

public class Main27 {

    private static Object o1 = new Object(), o2 = new Object();

    public void money(boolean flag) {
        if (flag) {
            synchronized (o1) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    System.out.println("1");
                }
            }
        }
        if (!flag) {
            synchronized (o2) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                    System.out.println("0");
                }
            }
        }
    }

    public static void main(String[] args) {
        Main27 main271 = new Main27();
        Main27 main272 = new Main27();

        final boolean[] flag = {false};
        Thread thread1 = new Thread(() -> main271.money(flag[0]));
        thread1.start();
        new Thread(() -> {
            try {
                thread1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag[0] = true;
            main272.money(flag[0]);
        }).start();
    }
}
