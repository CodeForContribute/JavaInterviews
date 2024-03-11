import java.util.ArrayList;
import java.util.List;

class Print<T>{
    T value;
    public T getValue(){
        return value;
    }
    public void setValue(T value){
        this.value = value;
    }
}
// Inherit with Generic class
class ColorPrint<T> extends Print<T>{

}

// more than one generic parameters
class Pair<K, V>{
    private K key;
    private V value;
    public void put(K key, V value){
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

// one method as Generic only
class GenericMethod{
    public <K,V> void printValue(Pair<K,V>a, Pair<K,V>b){
        if (a.getKey().equals(b.getKey())){
            // do something
        }
    }
}

class PrintGenericUsingGenericMethod{
    public <T> void setValue(T busObject){
        // do something
    }
}
class Vehicle{

}
class  Bus extends Vehicle{

}

class Bike extends Vehicle{

}
// Bounded Generics
// Object - Number -> (Float,Integer,BigDecimal, Long etc)
class BoundedGenerics<T extends Number>{
    // here we can pass only number and all the child class of number
    // for string or anything else , it will not work, it will throw compile time error.
}
// multi bound
//public class A extends ParentClass implements Interface1, Interface2{
//
//}
// if we want generic impl for above scenario, we will define below.
class ParentClass{

}
interface  Interface1{

}
interface  Interface2{

}
class MultiBoundGenerics<T extends ParentClass & Interface1 & Interface2>{
    T value;
    public T getPrintValue(){
        return value;
    }
    public void setPrintValue(T value){
        this.value = value;
    }
}

class WildCardGeneric{
    public void setObjects(List< ? extends Vehicle>vehicleList){

    }
}

// difference between wildcard and generic type method
class PrintV2{
    // wildCard method
    public void computeList(List<? extends Number>source,
                            List<? extends Number>destination){

    }
    // generic type method
    public <T extends Number> void computeListV2(List<T>source, List<T>destination){

    }

    /*
    * 1. In case of wild card , it supports lower and upper bound, which generic does not support.
    * 2. In case of generic type, source and destination type will be fixed to a single Type T,
    * while in wildCard, source could be List<Integer>, destination could be List<Double> or something else, number and
    * its child class.
    * 3. Generic type supports more than one type <k,v,z,a,b,c> while wildcard have one symbol - ?
    *
    * */
}
public class JavaGenerics {
    public static void main(String[] args) {
        Print<Integer> print = new Print<>();
        print.setValue(12);
        System.out.println(print.getValue());

        Print<Double> print1 = new Print<>();
        print1.setValue(12.4);
        System.out.println(print1.getValue());

        ColorPrint<String> colorPrint = new ColorPrint<>();
        colorPrint.setValue("1234");
        System.out.println(colorPrint.getValue());

        Pair<String, Integer> p = new Pair<>();
        p.put("hare", 1);

        PrintGenericUsingGenericMethod printGenericUsingGenericMethod = new PrintGenericUsingGenericMethod();
        printGenericUsingGenericMethod.setValue(new Bus());
        printGenericUsingGenericMethod.setValue(new Vehicle());

        List<Vehicle> vehicleList = new ArrayList<>();
        List<Bus> busList = new ArrayList<>();
        Bus busObj = new Bus();
        Vehicle vehicleObj = new Vehicle();
        vehicleObj = busObj;// valid childObj ref can be stored by parent
        // Invalid case
        // vehicleList = busList;
        // busList = vehicleList;
        WildCardGeneric wildCardGeneric = new WildCardGeneric();
        // wildCardGeneric.setObjects(busList); - throws error as we are
        // trying to store the list of bus object to list of vehicle;
        // hence will use wildcard to support this case
        // once we define this way - List< ? extends Vehicle>vehicleList
        // it will allow now
        wildCardGeneric.setObjects(busList);
        // List< ? super Vehicle>vehicleList - if we define, then it will allow Vehicle and its parent class
        // unbounded wildCard


    }
}
