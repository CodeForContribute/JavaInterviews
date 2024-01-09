package concepts.and.coding.videos.concurrency;

public class PrintEvenOddUsing2ThreadsV2 implements Runnable {
    static int counter = 1;
    final Object o;

    public PrintEvenOddUsing2ThreadsV2(Object o) {
        this.o = o;
    }

    public static void main(String[] args) {
        Object lock = new Object();
        Runnable r1 = new PrintEvenOddUsing2ThreadsV2(lock);
        Runnable r2 = new PrintEvenOddUsing2ThreadsV2(lock);
        Thread a = new Thread(r1);
        a.setName("odd");
        a.start();
        Thread b = new Thread(r2);
        b.setName("even");
        b.start();

    }

    @Override
    public void run() {
        while (counter <= 10) {
            if (counter % 2 == 0 && Thread.currentThread().getName().equals("even")) {
                synchronized (this.o) {
                    System.out.println("Thread name : >> " + Thread.currentThread().getName() + " value >> " + counter);
                    ++counter;
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        //e.printStackTrace();
                    }
                }
            }
            if (counter % 2 == 1 && Thread.currentThread().getName().equals("odd")) {
                synchronized (this.o) {
                    System.out.println("Thread name : >>> " + Thread.currentThread().getName() + " value >> : " + counter);
                    ++counter;
                    o.notify();
                }

            }
        }
    }
}
