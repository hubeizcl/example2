package company;

public class Main29 {
    private boolean hasDataToProcess = false;

    public boolean isHasDataToProcess() {
        return hasDataToProcess;
    }

    public void setHasDataToProcess(boolean hasDataToProcess) {
        this.hasDataToProcess = hasDataToProcess;
    }

    public static void main(String[] args) {
        final Main29 main29 = new Main29();
        Thread thread = new Thread(() -> main29.setHasDataToProcess(true));
        thread.start();
        new Thread(() -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t1 改变以后的值： " + main29.isHasDataToProcess());
        }).start();
    }
}
