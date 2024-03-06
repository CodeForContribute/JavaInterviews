import java.util.LinkedList;
import java.util.Stack;

public class GenericsLearning {
    /*
    You need to write a program that will print the values in descending order
    for a custom linkedlist that has random values in it.
    The disclaimers are -
    1) you should not use any pre-defined/out of the box java libraries/methods for the descending order logic
    2) you should neither use any existing algorithms nor take references from any of them

    linkedlist - 2,5,4,1,9,78
    op - 78,9,5,4,2,1

    s1 - [78,9,5,4,2,1], s2 - [1,2,4,5,9,78]

*/
    private static <T extends Comparable<T>> void printLinkedListInDecreasingOrder(LinkedList<T> list) {
        if (list == null || list.isEmpty()) return;
        Stack<T> s1 = new Stack<>();
        Stack<T> s2 = new Stack<>();

        for (T a : list) {
            while (!s1.isEmpty() && s1.peek().compareTo(a) < 0) {
                s2.push(s1.pop());
            }
            s1.push(a);
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        while (!s2.isEmpty()) {
            System.out.println(s2.pop());
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(2);
        list.add(5);
        list.add(4);
        list.add(1);
        list.add(-9);
        list.add(78);
        printLinkedListInDecreasingOrder(list);

        // 0, -200.5, 300.67, -200.6, 0, 300.68
        LinkedList<Double> list2 = new LinkedList<Double>();
        list2.add(0.0);
        list2.add(-200.5);
        list2.add(300.67);
        list2.add(-200.6);
        list2.add(0.0);
        list2.add(300.68);
        printLinkedListInDecreasingOrder(list2);
    }

}
