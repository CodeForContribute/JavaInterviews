package design.patterns.builder;

import java.util.Arrays;
import java.util.List;

class StudentV3{
    String name;
    int age;
    String fatherName;
    String motherName;
    List<String> subjects;

    public StudentV3(StudentBuilder studentBuilder) {
        this.name = studentBuilder.name;
        this.age = studentBuilder.age;
        this.fatherName = studentBuilder.fatherName;
        this.motherName = studentBuilder.motherName;
        this.subjects = studentBuilder.subjects;
    }

    @Override
    public String toString() {
        return "StudentV3{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", fatherName='" + fatherName + '\'' +
                ", motherName='" + motherName + '\'' +
                ", subjects=" + subjects +
                '}';
    }
}
// having common template for
// creating different types of Builder
abstract class StudentBuilder{
    String name;
    int age;
    String fatherName;
    String motherName;
    List<String>subjects;

    public StudentBuilder setName(String name){
        this.name = name;
        return this;
    }

    public StudentBuilder setAge(int age){
        this.age = age;
        return this;
    }
    public StudentBuilder setFatherName(String fatherName){
        this.fatherName = fatherName;
        return this;
    }
    public StudentBuilder setMotherName(String motherName){
        this.motherName = motherName;
        return this;
    }
    public abstract StudentBuilder setSubjects();
    public StudentV3 build(){
        return new StudentV3(this);
    }
}

class EngineeringStudentBuilder extends StudentBuilder{
    List<String>subjects;
    @Override
    public StudentBuilder setSubjects() {
        this.subjects = Arrays.asList("Math,CS");
        return this;
    }
}

class MBAStudentBuilder extends StudentBuilder{
    List<String>subjects;
    @Override
    public StudentBuilder setSubjects() {
        this.subjects = Arrays.asList("Math,Economics,Finance");
        return this;
    }
}
class Director{
    StudentBuilder studentBuilder;
    Director(StudentBuilder studentBuilder){
        this.studentBuilder = studentBuilder;
    }
    public StudentV3 createStudent(){
        if (studentBuilder instanceof  EngineeringStudentBuilder){
            return createEngineeringStudent();
        }else if (studentBuilder instanceof MBAStudentBuilder){
            return createMBAStudent();
        }
        return null;
    }

    private StudentV3 createMBAStudent() {
        return studentBuilder
                .setName("Ram")
                .setAge(20)
                .setFatherName("Dashrath")
                .setMotherName("Kausalya")
                .setSubjects()
                .build();
    }

    private StudentV3 createEngineeringStudent() {
        return studentBuilder
                .setName("Krishna")
                .setAge(20)
                .setFatherName("Vasudev")
                .setMotherName("Yasoda")
                .setSubjects()
                .build();
    }
}

public class BuilderClientDemo {
    public static void main(String[] args) {
        Director director = new Director(new EngineeringStudentBuilder());
        Director director2 = new Director(new MBAStudentBuilder());
        StudentV3 engineeringStudent = director.createStudent();
        StudentV3 mbaStudent = director2.createStudent();
        System.out.println(engineeringStudent.toString());
        System.out.println(mbaStudent.toString());
    }

}
