package CoreConcepts;

//class Print{
//    Object value;
//
//    public Object getValue() {
//        return value;
//    }
//
//    public void setValue(Object value) {
//        this.value = value;
//    }
//}
// Making use of Generic class
class Print<T>{
    T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
//class ColorPrint extends Print<String>{
//
//}

class ColorPrint<T> extends Print<T>{
}

// more than 1 generic type
class Pair<K,V>{
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
// Generic Method

class GenericMethodDemo{
    public <K,V> void printValue(Pair<K,V>a, Pair<K,V>b){
        if (a.getKey().equals(b.getKey())){
            // do something
        }
    }
}
// bounded generics
// it can be used at generic class and method.
// upper bound (<T extends Number>) means T can be of type Number or its subclass only.
//  Here superclass(in this example Number) we can have interface too.
// multi bound
class PrintV2<T extends Number>{
    T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}

interface Interface1{

}
interface  Interface2{

}
class ParentClass{

}

class A extends ParentClass implements Interface1, Interface2{

}
// we can extend Type parameter T to max to ParentClass,Interface1, Interface2
class PrintV3<T extends ParentClass & Interface1 & Interface2>{
    T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
public class GenericClassDemo {
    public static void main(String[] args) {
        /*
        * - What is Generic Class and what is the need of it?
            - How to define the Generic Class
            - Inheritance with Generic Classes
                  - Non Generic Subclass
                  - Generic Subclass
            - Multiple Type Parameters in Generic Class
            - Generic Methods
            - What is Raw Type
            - Bounded Generics
                 - Upper Bound
                 - Multi Bound
            - Wildcards
               - UpperBound
              - LowerBound
              - Unbounded
            - Type Erasure
        * */
        //  without generic class
//        Print print = new Print();
//        print.setValue(1);
//        Object printValue = print.getValue();
//        // here for different type of object, we have to do the typecasting
//        // Generic class solves this problem
//        if ((int)printValue == 1){
//            // do something
//        }
        Print<Integer>print = new Print<>();
        print.setValue(1);
        int printValue = print.getValue();
        // here we don't have to do the typecasting.
        if (printValue == 1){
              // do something
        }
        ColorPrint<String> colorPrint = new ColorPrint<String>();
        colorPrint.setValue("2");
        String val = colorPrint.getValue();
        System.out.println(val);
        Pair<Integer,String>pair = new Pair<>(1,"12");
        // Generic method--
        // What if we only wants to make generic method not the complete class, we can write
        // generic methods too.
        // Type parameter should be before the return type of the method declaration.
        // Type parameter scope is limited to method only.
        GenericMethodDemo genericMethodDemo = new GenericMethodDemo();
        genericMethodDemo.printValue(new Pair<Integer,String>(1,"2"), new Pair<>(2,"3"));
        genericMethodDemo.printValue(new Pair<Integer,Integer>(1,23), new Pair<Integer,Integer>(2,45));

        // bounded generics demo
       // PrintV2<Integer>integerPrintV2 = new PrintV2<>();
        // below object creation will give error as String does not extend to Number.
        // PrintV2<String>stringPrintV2 = new PrintV2<String>();
        A obj = new A();
        PrintV3<A>printV3Obj = new PrintV3<>();
    }
}
