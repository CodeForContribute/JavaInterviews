package CoreConcepts;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PriorityQueueDemo {
    /* iterable <- Collection <- Queue <- PriorityQueue
    * It is of 2 types, Minimum PriorityQueue and Max PriorityQueue
    * It is based on priority heap(min and max heap)
    * Elements are ordered according to either natural ordering(by default) or by
    * Comparator provided during queue construction time.
     */
    public static void main(String[] args) {
        PriorityQueue<Integer> minPriorityQueue = new PriorityQueue<Integer>();
        minPriorityQueue.add(3);
        minPriorityQueue.add(2);
        minPriorityQueue.add(8);
        minPriorityQueue.add(1);
        // printing all the values
        minPriorityQueue.forEach(System.out::println);
        // remove top element from the pq and print.
        while (!minPriorityQueue.isEmpty()){
            int val = minPriorityQueue.poll();
            System.out.println("remove from top: " + val);
        }

        PriorityQueue<Integer>maxPriorityQueue = new PriorityQueue<>((Integer a, Integer b)->b-a);
        maxPriorityQueue.add(2);maxPriorityQueue.add(1);maxPriorityQueue.add(12);
        maxPriorityQueue.add(3);
        // remove top element from the PQ and print
        while (!maxPriorityQueue.isEmpty()){
            int val = maxPriorityQueue.poll();
            System.out.println("remove from top: " + val);
        }
        //TC - Add and offer - O(log(n))
        // peek - O(1)
        // poll and remove head element - O(log(n))
        // remove arbitrary element - O(n)

        // Comparator Vs Comparable
        // It provides a way to sort the collection of objects.
        // primitive collection sorting
        int[]arr = {1,3,41,13};
        Arrays.sort(arr);
    }
}
