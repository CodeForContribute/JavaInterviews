package DesignPatterns;

interface Prototype{
    Prototype clone();
}

class Student{
    int age;
    private int rollNumber;
    String name;

    public Student() {
    }

    public Student(int age, int rollNumber, String name) {
        this.age = age;
        this.rollNumber = rollNumber;
        this.name = name;
    }
}

class StudentV2 implements Prototype{
    int age;
    private int rollNumber;
    String name;

    public StudentV2(int age, int rollNumber, String name) {
        this.age = age;
        this.rollNumber = rollNumber;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getName() {
        return name;
    }

    @Override
    public Prototype clone() {
        return new StudentV2(age,rollNumber,name);
    }
}


public class PrototypeClientDemo {
    /*
    * it is used when we have to make copy/clone from original/
    * existing object,when creating a base object is expensive.
    * Cloning responsibility should be not responsibility of client
    * instead it should be the responsibility of the original class.
    * which simplify the cloning logic. for this one, Prototype interface
    * need to be defined with a single method clone(to be consistent) across all the
    * class implementing this interface
    *
    * */
    public static void main(String[] args) {
        Student student = new Student(20,56,"Ram");
        Student clonedStudent = new Student();
        clonedStudent.name = student.name;
        clonedStudent.age = student.age;
        // first of all after creating new student object
        // we have to set the value from original object individually
        // also, we can access some or all properties of an object as below
        // clonedStudent.rollNumber
        StudentV2 studentV2 = new StudentV2(20,56,"Ram");
        StudentV2 clonedStudentV2 = (StudentV2) studentV2.clone();
        System.out.println("name " + clonedStudentV2.getName() + " " + " age: " + clonedStudentV2.getAge()
        +" rollNumber : " + clonedStudentV2.getRollNumber());
        System.out.println(clonedStudentV2 == studentV2);

    }
}
