package CoreConcepts;

public class ThreadCreationRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Code getting executed by thread:" + Thread.currentThread().getName());
    }
}
