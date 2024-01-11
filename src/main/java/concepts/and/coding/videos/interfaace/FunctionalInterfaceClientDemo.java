package concepts.and.coding.videos.interfaace;

@FunctionalInterface
interface Bird{
    void canFly(String val);

}

class BirdImplUsingImplements implements Bird{
    @Override
    public void canFly(String val) {
        System.out.println("Eagle bird can fly : " + val);
    }
}
// Consumer functional interface
// * 1. Consumer -
//    *       a. represents an operation, that accepts a single input param that returns no result
//    *       b. present in java.util.function
@FunctionalInterface
interface Consumer<T>{
    void accept(T t);
}
//
//    * 2. Supplier -
//        *       a.represents the supplier of the result.
//        *       b. accepts no input param but produce a result.
//        *

@FunctionalInterface
interface Supplier<T>{
    T get();
}

@FunctionalInterface
interface Function<T,R>{
    R apply(T t);
}

//interface LivingThing{
//    public void canBreathe();
//}
//
//@FunctionalInterface - this will be error as functional interface should be having one abstract method
//interface LivingBird extends LivingThing{
//    void canFly(String val);
//}

// but below is valid
interface LivingThing{
    public default boolean canBreathe(){
        return true;
    }
    public static boolean canBreatheInWater(){
        return false;
    }
    String toString();
}

@FunctionalInterface
interface LivingBird extends LivingThing{
    void canFly(String val);
}
public class FunctionalInterfaceClientDemo {
    /*
    * Functional interface - contains one abstract method
    * @FunctionalInterface kwd is used to identify this interface.
    * It restricts us and throws compilation err, if we try to add more than 1 abstract method.
    * In Functional interface,only 1 abstract method is allowed,but we can have other methods like default,static or methods inherited from object class.
    * like toString() method
    *
    * Lambda Expression - it is a way to implement the functional interface.
    * Diff way of implementing th functional interface
    * 1. using implements
    * 2. using anonymous class
    * 3. using lambda expression
    * Types of functional interfaces
    * 1. Consumer -
    *       a. represents an operation, that accepts a single input param that returns no result
    *       b. present in java.util.function
    * 2. Supplier -
    *       a.represents the supplier of the result.
    *       b. accepts no input param but produce a result.
    *
    * 3. function -
    *       a. represent function, that accepts one arg process it and produce a result
    *       b. present in java.util.function
    * 4. handle use case when functional interface extends from other interface.
    * Use case 1: - functional interface extending non-functional interface.
    * */



    public static void main(String[] args) {
        // using implements keyword
        Bird eagleObj = new BirdImplUsingImplements();
        eagleObj.canFly("vertical");
        // using anonymous class
        Bird eagleObject = new Bird() {
            @Override
            public void canFly(String val) {
                System.out.println("bird can fly : " + val);
            }
        };
        eagleObject.canFly("vertical");
        // using lambda expression
        Bird eagleObjectUsingLambda = (String val) -> {
            System.out.println("Eagle bird implementation");
        };
        eagleObjectUsingLambda.canFly("vertical");

        // demo of consumer functional interface
        Consumer<Integer>consumer = (Integer val)->{
            if (val > 10){
                System.out.println("Logging !!!!");
            }
        };

        // demo of producer functional interface
        Supplier<String>isEvenNumber = ()->"this is the data returned";
        System.out.println(isEvenNumber.get());

        // demo of function functional interface
        Function<Integer,String>integerToString = (val)->{
            String numAsString = val.toString();
            return numAsString;
        };
        System.out.println(integerToString.apply(12));
    }
}
