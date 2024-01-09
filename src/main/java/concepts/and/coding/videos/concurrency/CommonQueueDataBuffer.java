package concepts.and.coding.videos.concurrency;


import java.util.Queue;

public class CommonQueueDataBuffer {
    private final Queue<Integer> sharedBuffer;
    private final int bufferSize;

    public CommonQueueDataBuffer(Queue<Integer> sharedBuffer, int bufferSize) {
        this.sharedBuffer = sharedBuffer;
        this.bufferSize = bufferSize;
    }

    public synchronized void produce(int item) throws Exception {
        while (sharedBuffer.size() == bufferSize) {
            System.out.println("Buffer is full, producer waiting for consumer to consume data");
            wait();
        }
        sharedBuffer.add(item);
        System.out.println("produced: " + item);
        // notify the consumer that there are items to be consumed
        notify();
    }

    public synchronized int consume() throws Exception {
        while (sharedBuffer.isEmpty()) {
            System.out.println("Buffer is empty,consumer is waiting for producer");
            wait();
        }
        int item = sharedBuffer.poll();
        System.out.println("Consumed: " + item);
        notify();
        return item;
    }
}
