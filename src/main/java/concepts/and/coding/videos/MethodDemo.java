package concepts.and.coding.videos;

public class MethodDemo {
    public int sum(int a, int b){
        int total = a+b;
        System.out.println("addition of a and b is : " + total);
        return total;
    }
    public static void main(String[] args) {
        /*
        1. it is used to perform certain task
        2.collection of instructions
        3. can be used to bring the code readability and re-usability
        Access specifiers -
            public - can be access to any class in any package.
            private - can not be access outside of class where it is defined
            protected - can be access within classes of the same package not
                any outside class of this package except if the class where this protected method defined
                becomes the parent of any class in other package, then it can be accessed.
            default - if we don't mention anything,then default access specifier is used by java. it can
            be only accessed by classes in same package , not even in sub-class of this class of default method.
            method name should be a verb(some kind of action)
            it should be in camelCase

            Types of methods
            1. System defined methods - provided by java.
            2. User-defined - coder writes
            3. Overloaded method -
                    more than one method with same method name,
                 but with different  type/number of args - static binding
                 - return type can be same or different , it does not matter
                 only the type and number of args should be different
                Overriding - dynamic binding
            4. Override methods - same method signature in subclass/child class
                @Override - is optional when child extends the parent class but signature
                should be same. - dynamic binding
                Person person = new Doctor()
                person.profession() -

            5. static methods -
                These are associated with class
                can be called  just with class name
                common for all objects - not associated with any instance/object
                static methods can not access non-static instance,methods and variables
                it can not be overriden - as override - dynamic binding so it is decided which
                create method as static only when it is manipulating args not the instance state.
           6. final methods
            - subclass can change the method impl of parent class
            - to avoid method impl in child class, we have to add final to the parent class method
            - no overriden - as it is added to avoid that only
           7. abstract methods
            - it is defined only in abstract class.
            - it will be having only declarations.
            - child class will be having responsibility to implement the abstract methods
           8. Variable arguments(Vargs)
           - it will be used as  int...args - it can take 1 and more than 1 args
           - it can be used as a list - we can iterate it using for loop.
            - it will be the last args in method args
        * */
    }
}
