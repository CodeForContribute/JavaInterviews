package DesignPatterns;

/*
* 1. S - Single responsibility - class should have single reason to change
* */

class Marker{
    String name;
    String color;
    int year;
    int price;

    public Marker(String name, String color, int year, int price) {
        this.name = name;
        this.color = color;
        this.year = year;
        this.price = price;
    }
}

class Invoice{
    private Marker marker;
    private int quantity;

    public Invoice(Marker marker, int quantity) {
        this.marker = marker;
        this.quantity = quantity;
    }
    public int calculatePrice(){
        // let's bring the GST into calculating price
        // then there need to change the price
        return (marker.price) * quantity;
    }
    public void printInvoice(){
        // print invoice
        // if we change the strategy of printing as well, here change need to be done
    }
    public void saveToDB(){
        // save the data into DB
        // let's we want to save to File then a change
        // need to be done.
    }
    // so there are 3 reasons to change - so it is not following single
}

class ImprovedInvoice{
    private Marker marker;
    private int quantity;

    public ImprovedInvoice(Marker marker, int quantity) {
        this.marker = marker;
        this.quantity = quantity;
    }
    public int calculateTotal(){
        int price = (marker.price)*quantity;
        return price;
    }
}

// to save to db - we will create a separate class
class InvoiceDao{
    private ImprovedInvoice improvedInvoice;

    public InvoiceDao(ImprovedInvoice improvedInvoice) {
        this.improvedInvoice = improvedInvoice;
    }
    public void saveInvoiceToDB(){
        // saving the invoice to db
    }
}

class InvoicePrinter{
    private ImprovedInvoice improvedInvoice;

    public InvoicePrinter(ImprovedInvoice improvedInvoice) {
        this.improvedInvoice = improvedInvoice;
    }
    public void printInvoice(){
        // printing the invoice
    }
}

// Open-Closed principle - Open for extension and closed for modification
// let's in the above example we have to change the saving invoice to a file apart from db
// so if we change the InvoiceDao class for saving to file , it will lead to change in the existing filea
// and hence will lead to bug
// so as per Open-closed principle - we can create an interface as below and DB daa and file dao
// will implement this interface and hence the existing code will not change and new code for saving to file
// will be in separate class

interface ImprovedInvoiceDao{
    public void save(ImprovedInvoice improvedInvoice);
}

class DatabaseInvoiceDao implements ImprovedInvoiceDao{
    @Override
    public void save(ImprovedInvoice improvedInvoice) {
        // save to DB logic here
    }
}
class FileInvoiceDao implements ImprovedInvoiceDao{
    @Override
    public void save(ImprovedInvoice improvedInvoice) {
        // save to file logic here
    }
}
// Liskov substitution principle
// if class B is child/subtype of class A, then we should be
// able to replace object of A with B without breaking the behavior
// of the program
// Subclass should extend the capability of parent class not narrow it down

interface Bike{
    void turnOnEngine();
    void accelerate();
}

class MotorCycle implements Bike{
    private boolean isEngineOn;
    private int speed;
    public MotorCycle() {
        this.isEngineOn = false;
        this.speed = 10;
    }

    @Override
    public void turnOnEngine() {
        this.isEngineOn = true;
    }

    @Override
    public void accelerate() {
        this.speed = speed + 10;
    }
}
class Cycle implements Bike{
    private int speed;
    public Cycle() {
        this.speed = 0;
    }
    @Override
    public void turnOnEngine() {
        // Since cycle does not have engine
        // and hence it is limiting/narrowing down
        // the capability of the parent class Bike
        // so the parent class/object Bike can not be substituted
        // with child class Cycle and hence does not follow
        // liskov substitution principle.
        throw new AssertionError("There is no engine to turn on");
    }
    @Override
    public void accelerate() {
        this.speed += 10;
    }
}

// Interface should be such that client should not implement
// unnecessary function they don't need.
// example

interface RestaurantEmployee{
    void washDishes();
    void serveCustomers();
    void cookFood();
}
class Waiter implements RestaurantEmployee{
    @Override
    public void washDishes() {
        // nothing here as waiter will not be washing dishes
    }

    @Override
    public void serveCustomers() {
        System.out.println("serving customers >>>>>>>>>>");
    }

    @Override
    public void cookFood() {
        // nothing here as waiter wil not be cooking food
    }
    // so waiter class also has to implement these methods
    // though it is not required and hence it leads to interface
    // segregation as follows
}

interface WaiterInterface {
    void takeOrder();
    void servCustomers();
}

interface ChefInterface{
    void decideMenu();
    void cookFood();
}
interface HelperInterface{
    void cleanDishes();
}

class HotelWaiter implements WaiterInterface{

    @Override
    public void takeOrder() {
        System.out.println("Taking order >>>>>>>>");
    }
    @Override
    public void servCustomers() {
        System.out.println("Serving Customers >>>>>>");
    }
}

// Dependency inversion
// Class should depend on interface rather than concrete classes.
interface KeyBoard{

}
interface Mouse{

}
class WiredKeyBoard implements KeyBoard{

}
class  WiredMouse implements Mouse{

}

class BlueToothKeyBoard implements KeyBoard{

}
class  BlueToothMouse implements Mouse{

}
class MacBook{
    // here we are hardcoding the type of keyboard and mouse
    // to concrete classes - which will be hard to change
    // so we will do constructor dependency injection of interfaces
    // so that we can inject any type of concrete classes for KeyBoard and Mouse
//    private final WiredKeyBoard wiredKeyBoard;
//    private final WiredMouse wiredMouse;
//
//    public MacBook(WiredKeyBoard wiredKeyBoard, WiredMouse wiredMouse) {
//        this.wiredKeyBoard = wiredKeyBoard;
//        this.wiredMouse = wiredMouse;
//    }
    private final KeyBoard keyBoard;
    private final Mouse mouse;

    public MacBook(KeyBoard keyBoard, Mouse mouse) {
        this.keyBoard = keyBoard;
        this.mouse = mouse;
    }
}
public class SolidPrincipleClientDemo {
    /*
    * 1. S - Single responsibility - class should have single reason to change
    * 2. O - Open for extension and closed for modifications
    * 3. L - Liskov substitution - child/subclass class object can be used instead of  Parent object without changing the behaviour.
    * 4. I - Interface segregation principle - interface should be defined in such a way that the class implementing the interface
    *       should not implement those methods which are not necessary.
    * 5. D - Dependency inversion -
    * */
    public static void main(String[] args) {
    }
}
