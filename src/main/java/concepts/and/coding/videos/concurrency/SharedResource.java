package concepts.and.coding.videos.concurrency;

public class SharedResource {
    boolean isItemAvailable = false;

    public synchronized void addItem() {
        isItemAvailable = true;
        System.out.println("Item added by: " + Thread.currentThread().getName() + " and invoking all threads which are waiting");
        notifyAll();
    }

    public synchronized void consumeItem() {
        System.out.println("ConsumeItem method invoked by: " + Thread.currentThread().getName());
        // using while loop to avoid 'spurious wake-up', sometimes because of system noise.
        while (!isItemAvailable) {
            try {
                System.out.println("Thread: " + Thread.currentThread().getName() + " is waiting now");
                wait();
            } catch (Exception e) {
                // some exception handling here
            }
            System.out.println("Item consumed by: " + Thread.currentThread().getName());
            isItemAvailable = false;
        }
    }
}
