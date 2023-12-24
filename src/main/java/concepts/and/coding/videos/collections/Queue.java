package concepts.and.coding.videos.collections;

public class Queue {
    public static void main(String[] args) {
        /*
        * It is an interface,child of collection interface.
        * Generally QUEUE follows FIFO approach,but there are exceptions PriorityQueue.
        * it supports all the methods available in Collection + some other methods mentioned below.
        *
        * 1. add() - insert the element into the queue
        *       - True if insertion is successful and Exception if insertion fails.
        *       - Null element insertion is not allowed will throw(NPE)
        *
        * 2. offer() - insert the element into the queue
        *            - True if insertion is successful and false if insertion fails.
        *            - Null element insertion is not allowed will throw(NPE)
        *
        * 3. poll() - retrieves and removes the head of the queue.
        *           - returns null if Queue is Empty.
        *
        * 4. remove() - retrieves and removes the head of the queue
        *              - returns Exception(NoSuchElementException) if queue is empty.
        *
        * 5. peek() - retrieves the value present at the head of the queue but do not removes it.
        *              returns null if queue is empty.
        *
        * 6. element() - retrieves the value present at the head of the queue, but don't removes it.
        *               - returns an Exception(NoSuchElementException) if queue is empty.
        *
         * */
    }
}
