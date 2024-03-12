package CoreConcepts;

public class MonitorLockExample {
    public synchronized void task1() {
        try {
            System.out.println("inside task 1 >>>>>>");
            Thread.sleep(10000);
            System.out.println("after task 1 finished >>>>>>");
        } catch (Exception e) {
            // some exception handling here
        }
    }

    public void task2() {
        System.out.println("task2 , before synchronized >>>>>");
        synchronized (this) {
            System.out.println("task2 , inside synchronized >>>>>>");
        }
    }

    public void task3() {
        System.out.println("Task3 >>>>>>>>>>>>");
    }
}
