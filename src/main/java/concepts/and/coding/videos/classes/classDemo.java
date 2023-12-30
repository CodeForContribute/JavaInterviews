package concepts.and.coding.videos.classes;

class OuterClass{
    int instanceVariable = 10;
    static int classVariable = 20;

    static class NestedStaticClass{
        public  void print(){
            // can not access non-static member of outer class.
            // can access only static member of outer class.
            //System.out.println(instanceVariable);
            System.out.println(classVariable);
        }
    }
}

class OuterClassWithPrivateNestedStaticClass{
    int instanceVariable = 10;
    static int classVariable = 20;
    private static class NestedClass{
        public void print(){
            System.out.println("class Variable : " + classVariable);
        }
    }
    public void display(){
        NestedClass nestedObj = new NestedClass();
        nestedObj.print();
    }
}

class OuterClassWithInnerClass{
    private final int instanceVariable = 10;
    private static final int staticClassVariable = 20;
    public class InnerClass{
        public void print(){
            System.out.println(staticClassVariable + instanceVariable);
        }
    }
}
class OuterClassWithLocalInnerClass{
    private final int instanceVariable = 10;
    private static final int staticVariable = 20;

    public void display(){
        int methodVariable = 3;
        // it can not be public private protected,it can only be default
        class LocalInnerClass{
            final int localInnerVariable = 4;
            public void print(){
                System.out.println(instanceVariable + staticVariable +methodVariable+localInnerVariable);
            }
        }
        LocalInnerClass localInnerClass = new LocalInnerClass();
        localInnerClass.print();
    }
}

class OuterClassWithNestedStaticClassInheritance{
    static class NestedClass{
        public void display(){
            System.out.println("inside static nested class >>>>>");
        }
    }
}

class SomeOtherClass extends OuterClassWithNestedStaticClassInheritance.NestedClass{
    @Override
    public void display() {
        super.display();
    }

}

class OuterClassWithNestedInnerClassInheritance{
    class InnerClass{
        public void display(){
            System.out.println("Inside nested inner class >>>>>");
        }
    }
}
class Something extends OuterClassWithNestedInnerClassInheritance.InnerClass{
    Something(){
        new OuterClassWithNestedInnerClassInheritance().super();
        // as we know, when child class constructor invoked, it first invoked the constructor of parent.
        // but here the parent is inner class, so it can only be access by the object of outer class only.
    }

    @Override
    public void display() {
        super.display();
    }
}
abstract  class  car{
    public abstract void pressBreak();
}
public class classDemo {
    public static void main(String[] args) {
        /*
        *  • Concrete Class
            • Abstract Class
            • Super Class and Sub Class
            • Object Class
            • Nested Class
              - Inner Class (Non Static Nested Class)
              - Anonymous Inner Class
              - Member Inner Class
              - Local Inner Class
              - Static Nested Class / Static Class
            • Generic Class
            • POJO Class
            • Enum Class
            • Final Class
            • Singleton Class
            • Immutable Class
            • Wrapper Class
            Chapters:
            00:00 - Introduction
            00:57 - Concrete Class
            03:14 - Abstract Class
            10:43 - SuperClass, SubClass and Object Class
            16:47 - Nested Class
            20:32 - Static Nested Class
            28:26 - Non Static Nested or Inner Class
            30:54 - Member and Local Inner Class
            37:22 - Inheritance of Nested Class
            44:46 - Anonymous Inner Class
        *
        *
        * */
        // Concrete class
        // Abstract class
        // Nested class
        // we have 2 types of nested class
        // static and non-static nested class.
        // non-static nested class
            // member inner class
            // local inner class
            // anonymous inner class
        // static nested class
        // 1.  it does not have access to non-static instance
        // variable and method of outer class.
        // 2. it's object can be initiated without initiating the object of outer class.
        // 3. It can be private,public,protected or package private(default, no explicit declaration)
        OuterClass.NestedStaticClass nestedClassObj= new OuterClass.NestedStaticClass();
        nestedClassObj.print();
        OuterClassWithPrivateNestedStaticClass outerClassWithPrivateNestedStaticObj = new OuterClassWithPrivateNestedStaticClass();
        outerClassWithPrivateNestedStaticObj.display();
        // inner class or non-static nested class.
        // it has access to all the instance variable and method of outer class.
        // its object can be initiated after initiating the object of outer class.
        // 1. member inner class - it can be public private, protected, default.
        OuterClassWithInnerClass outerClassWithInnerClassObj = new OuterClassWithInnerClass();
        OuterClassWithInnerClass.InnerClass innerClassObj = outerClassWithInnerClassObj.new InnerClass();
        innerClassObj.print();
        // 2. local inner class - creating inner class inside if-else block or any block
        // it can not be declared as private, protected, public. Only default(not defined explicit)
        // access modifier is used.
        // it can not be initiated outside of this block.
        OuterClassWithLocalInnerClass outerClassWithLocalInnerClassObj = new OuterClassWithLocalInnerClass();
        outerClassWithLocalInnerClassObj.display();
        /*
        * Inheritance in nested inner class
        *
        * */
        SomeOtherClass someOtherClassObj = new SomeOtherClass();
        someOtherClassObj.display();
        Something something = new Something();
        something.display();
        // any class without a name is called anonymous.
        // it is used when we want to override the behaviour of the method without even creating any subclass.
        car audiObj = new car() {
            @Override
            public void pressBreak() {
                System.out.println("break pressed");
            }
        };
        audiObj.pressBreak();
        // 2 things happened behind the scene
        // subclass is created, name decided by the compiler.
        // creates an object of subclass and assign its reference to object "audiObj"
        // similarly it works same for interface as well.
    }
}
