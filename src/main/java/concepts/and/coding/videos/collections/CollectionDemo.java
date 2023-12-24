package concepts.and.coding.videos.collections;

import java.util.*;

public class CollectionDemo {
    public static void main(String[] args) {
        /*
        * Added in java version 1.2
        * Collections is nothing but a group of objects
        * present in java.util package
        * it is a framework as it provide us the architecture to manage
        * these group of objects i.e add,update delete search etc
        *
        * Why need.
        * Prior to JCF, we have Array,Vector,HashTables.
        * But problem with that is , there is no common interface, so its difficult
        * to remember the methods for each
        * */
        int[]arr = new int[4];
        // insert an element in an arr
        arr[0] = 1;
        // get front element
        int val = arr[0];

        Vector<Integer>vector = new Vector<>();
        // insert an element in vector
        vector.add(1);
        // get element
        vector.get(0);

        // iterator working ....
        List<Integer>values = new ArrayList<>();
        values.add(1);values.add(2);values.add(3);values.add(4);
        Iterator<Integer>valuesIterator = values.iterator();
        while (valuesIterator.hasNext()){
            int value = valuesIterator.next();
            System.out.println("value >>>>> " + value);
            if (value == 3){
                valuesIterator.remove();
            }
        }
        for (int value:values){
            System.out.println(value);
        }
        // using foreach method
        values.forEach(System.out::println);
        System.out.println("size: " + values.size());
        System.out.println("isEmpty: " + values.isEmpty());
        System.out.println("contains: " + values.contains(4));
        values.add(5);
        System.out.println("values added: " + values.contains(5));
        // remove ele using an index
        values.remove(2); // remove element at index 2
        values.remove(Integer.valueOf(3));// removing value 3 from list
        Stack<Integer>stack = new Stack<>();
        stack.add(3);stack.add(2);stack.add(1);
        // addAll;
        values.addAll(stack);
        System.out.println("addAll test using containsAll: " + values.containsAll(stack));
        // remove all
        values.removeAll(stack);
        //clear
        values.clear();
        System.out.println("is List empty: " + values.isEmpty());
    }
}
