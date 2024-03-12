package CoreConcepts;

public class MonitorLockProducerConsumerDemo {
    public static void main(String[] args) {
        System.out.println("Main method start >>>>>>>>>>>>>>>");
        SharedResource sharedResource = new SharedResource();
        // producer thread
        Thread producerThread = new Thread(new ProducerTask(sharedResource));
        // consumer thread
        Thread consumerThread = new Thread(new ConsumerTask(sharedResource));
        producerThread.start();
        consumerThread.start();
        System.out.println("Main method end >>>>>>>>>>>>>");
    }
}
