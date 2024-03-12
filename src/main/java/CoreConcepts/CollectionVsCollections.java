package CoreConcepts;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class CollectionVsCollections {
    /*
    * Collection is part of java collection framework.And it is an interface,
    * which expose various methods which is implemented by various collection classes
    * like ArrayList,Stack,LinkedList etc.
    *
    * Collections - is a utility class and provide static methods, which are used to operate on collection
    * like sorting, swapping, searching,reverse,copy etc
    * methods - sort,binarySearch,get,reverse,shuffle,swap,copy,min,max,rotate,unmodifiableCollection
    * */
    public static void main(String[] args) {
        List<Integer> values = new ArrayList<>();
        values.add(1);values.add(3);values.add(2);values.add(5);
        System.out.println("max Value: " + Collections.max(values));
        System.out.println("min Value: " + Collections.min(values));
        Collections.sort(values);
        System.out.println("sorted");
        values.forEach(System.out::println);
    }
}
