package CoreConcepts;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerDemo {
    /*
     * Stop, Resume,Suspended method is deprecated.
     * Stop - terminates the thread abruptly, no lock release, no resource clean up.
     * Suspend - put the thread on hold(suspend) for temporarily, no lock release too.
     * Resume - used to resume the execution of suspended thread.
     * Both this operation could let to issues like deadlock.
     *
     * Join - This method is invoked on a thread object.current thread will be blocked and waits
     * for the specific thread to finish.
     * It is helpful when we want to co-ordinate between
     * threads or to ensure we complete certain tasks before moving ahead.
     *
     * Thread Priority
     * - Priorities are integer ranging from 1-10.
     * 1- low priority
     * 10 - highest priority.
     * Note - even if we set the thread priority while creation, it is not guaranteed to follow any specific order,
     * it is just a hint to thread scheduler which to execute next. but it is not a strict rule.
     *
     * When a new thread is created, it inherit the priority of its parent thread.
     * We can set custom priority using "setPriority(int priority)" method.
     *
     * Daemon thread - This thread will keep executing even if the main thread completes executed.
     *
     * */
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        CommonQueueDataBuffer sharedObj = new CommonQueueDataBuffer(q, 3);
        Thread producerThread = new Thread(() -> {
            try {
                for (int i = 1; i <= 6; ++i) {
                    sharedObj.produce(i);
                }
            } catch (Exception e) {
                // handle exception here
            }
        });
        Thread consumerThread = new Thread(() -> {
            try {
                for (int i = 1; i <= 6; ++i) {
                    int item = sharedObj.consume();
                    System.out.println("Item received from q: " + item);
                }
            } catch (Exception e) {
                //
            }
        });
        producerThread.start();
        consumerThread.start();
    }


}
