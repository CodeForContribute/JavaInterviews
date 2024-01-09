package concepts.and.coding.videos.concurrency;

import java.util.concurrent.locks.ReentrantLock;

public class SharedResourceV2 {
    boolean isAvailable = false;
    ReentrantLock lock = new ReentrantLock();

    public void produce() {
        // thread will try to get the lock
        try {
            lock.lock();
            System.out.println("Lock acquired by: " + Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(4000);
        } catch (Exception e) {
            // some exception
        } finally {
            lock.unlock();
            System.out.println("Lock released by : " + Thread.currentThread().getName());
        }
    }

    public void consume() {
        // consumer thread will try to acquire the lock
        try {
            lock.lock();
            System.out.println("write lock acquired by: " + Thread.currentThread().getName());
            isAvailable = false;
        } catch (Exception e) {
            //
        } finally {
            lock.unlock();
            System.out.println("write lock released by : " + Thread.currentThread().getName());
        }
    }
}
