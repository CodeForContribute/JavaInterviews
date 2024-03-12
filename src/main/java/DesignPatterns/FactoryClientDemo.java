package DesignPatterns;


interface Shape{
    public void computeArea();
}

class Circle implements Shape{
    @Override
    public void computeArea() {
        System.out.println("Circle Area >>>>>>>");
    }
}
class Rectangle implements Shape{
    @Override
    public void computeArea() {
        System.out.println("Rectangle Area >>>>>>>>>");
    }
}
class Square implements Shape{
    @Override
    public void computeArea() {
        System.out.println("Square Area >>>>>>>>>>>>");
    }
}
enum ShapeType{
    SQUARE,
    CIRCLE,
    RECTANGLE
}

class ShapeFactory{
    public Shape getShapeInstance(ShapeType shapeType){
        switch (shapeType){
            case SQUARE:
                return new Square();
            case RECTANGLE:
                return new Rectangle();
            case CIRCLE:
                return new Circle();
        }
        return null;
    }
}
public class FactoryClientDemo {
    /*
    * It handles the logic of creation and using of different objects
    * separately. If the logic of creation changes, no need to change the client
    * using these classes/objects
    * Also, it removes the unnecessary use of if-else blocks for checking the condition
    * when to create which class. - we have to handle though but this logic will
    * reside in a separate class called "factory"- which encapsulates the logic for
    * conditional checks and creation of objects, the client code just need to call this
    * class object and pass the object type the factory has to create and return to the client.
    * */
    ShapeFactory shapeFactory = new ShapeFactory();
    Circle circleObject = (Circle) shapeFactory.getShapeInstance(ShapeType.CIRCLE);

}
