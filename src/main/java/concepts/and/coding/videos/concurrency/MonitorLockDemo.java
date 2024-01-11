package concepts.and.coding.videos.concurrency;

public class MonitorLockDemo {
    /*
     * It helps to make sure only one thread goes inside the particular section of code
     * ( a synchronized block or method)
     *
     * */
    public static void main(String[] args) {
        MonitorLockExample obj = new MonitorLockExample();
        Thread a = new Thread(obj::task1);
        Thread b = new Thread(obj::task2);
        Thread c = new Thread(obj::task3);
        b.start();
        a.start();
        c.start();
    }
}
