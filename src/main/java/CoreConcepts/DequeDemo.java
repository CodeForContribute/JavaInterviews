package CoreConcepts;

import com.sun.jdi.IntegerType;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.PriorityBlockingQueue;

public class DequeDemo {
    public static void main(String[] args) {
        /*
        * stands for Double ended Queue. means addition and removal can be done from
        * both sides of the queue.
        * Iterable <- Collection <- Queue <- Dequeue <- ArrayDeque(ConcreteImpl).
        * Iterable <- Collection <- Queue <- PriorityQueue(ConcreteImpl).
        * Methods available in Dequeue interfaces
        * methods available in collections + method available in queue interface
        * + methods available in Deque interface
        * Queue - add(), offer(), poll(), remove(),peek(), element()
        * 1. insert operations
        *   a. addFirst(e) Throws exception - add element e to the first of the queue,throws error if null is added.
        *   b. offerFirst(e) - return true/false - if element e is added to start of the queue else return false;
        *   c. addLast(e) throws Exception - add element e to the last of the queue.
        *   d. offerLast(e) - return true/false - don't throw exception
        *  we can use ArrayDeque as Stack, to use it as a stack, push() and pop() methods are available.
        * push() - internally calls addFirst()
        * pop() - internally call removeFirst()
        * */
        ArrayDeque<Integer>arrayDeque = new ArrayDeque<>();
        arrayDeque.add(1);
        arrayDeque.add(2);
        arrayDeque.add(4);
        // deletion
        int element = arrayDeque.removeFirst();
        System.out.println(element);
        // LIFO
        ArrayDeque<Integer>stack = new ArrayDeque<>();
        stack.addFirst(1);
        stack.addFirst(2);
        stack.addFirst(4);
        // deletion
        int removedElement = stack.removeFirst();
        System.out.println(removedElement);
        // as arrayDeque implements Queue and Deque interfaces both
        // so when add() gets called, it calls addLast()
        // offer() - offerLast();
        // poll() - calls pollFirst()
        // remove() - calls removeFirst()
        // peek() - calls peekFirst()
        // element() - calls getFirst()
        // TC - insertion - amortized(most of the time or average) complexity is O(1)
        // except in case when queue gets filled with initial size - in that case - O(n)
        // deletion - O(1)
        // search - O(n)
        // space complexity - O(n)

        // PriorityQueue - not threadsafe, does not maintain order,no null elements allowed,duplicate elements allowed.
        // ThreadSafe PriorityQueue - PriorityBlockingQueue
        PriorityBlockingQueue<Integer>pq = new PriorityBlockingQueue<>();
        pq.add(1);pq.add(3);pq.add(12);
        System.out.println(pq.peek());
        // ArrayDeque - not threadsafe, maintain order, no null elements allowed,dup allowed.
        // Thread safe ArrayDeque - ConcurrentLinkedDeque
        ConcurrentLinkedDeque<Integer>deque = new ConcurrentLinkedDeque<>();
        deque.addFirst(1);deque.addLast(12);
        deque.addFirst(3);deque.add(13);
        System.out.println(deque.peek());
        // List - it is a ordered collection of an object. int which duplicate values can be stored.
        // Different from Queue - in Queue, insertion/removal/access can only happen either at start or end of the queue.
        // while in list, data can be inserted,removed,accessed from anywhere.
        // in list, wer can decide where to insert or access using index(starting from 0).
        // iterable <- collection <- list <- ArrayList(Concrete impl.)
        // iterable <- collection <- list <- Vector(Concrete impl.)
        // iterable <- collection <- list <- Vector(Concrete impl.) <- stack(concrete impl.)
        // iterable <- collection <- (list + Deque) <- LinkedList(Concrete impl.)
        // methods available in list interface
        // ArrayList - not thread safe
        List<Integer>list = new CopyOnWriteArrayList<>();
        list.add(0,100);
        System.out.println(list.get(0));
        // LinkedList - data structure - linked list.
        // it implements both Deque and List interface.
        // it supports get(index) , add(index, object) etc.
        // linkedList as Deque
        LinkedList<Integer>linkedList = new LinkedList<>();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addLast(4);
        linkedList.addLast(4);

        // using list functionality
        linkedList.add(0,100);
       // linkedList.add(5,1221);
        System.out.println(linkedList.getFirst() + " last >> " + linkedList.getLast() + " 100th index >> " + linkedList.get(3));
        // TC - insertion at start and end - O(1)
        // insertion at particular index - O(n) for lookup + O(1) for adding
        // search - O(n)
        // deletion at start or end - O(1)
        // deletion at specific index - O(n) + O(1) removal.
        // space - O(n)
        // LinkedList is not thread safe, maintains order, null elements allowed,
        // duplicates are allowed


        // Vector
        // exactly same as arrayList ,elements can be access via index.
        // it is thread safe.
        // puts lock when operation is performed on vector.
        // less efficient than arrayList as for each operation as it has to lock/unlock internally.
        Vector<Integer>vector = new Vector<>();
        vector.add(1);vector.add(2);
        System.out.println(vector.get(0));
        // Stack - LIFO
        // extends Vector, its methods synchronized.
        // Deque is not thread safe, it is.
        Stack<Integer>st = new Stack<>();
        st.push(1);st.push(3);
        System.out.println(st.pop());
        System.out.println(st.pop());

    }
}
