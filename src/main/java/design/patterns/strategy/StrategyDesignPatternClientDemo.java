package design.patterns.strategy;

class Vehicle{
    void drive(){
        //some code here
    }
}
class SportyVehicle extends Vehicle{
    @Override
    void drive() {
        // specific to this class
    }
}
class OffRoadVehicle extends Vehicle{
    @Override
    void drive() {
        // specific to this class
    }
}
class PassengerVehicle extends Vehicle{
    // will reuse the parent class drive method
}

// in the above case of SportyVehicle,OffRoadVehicle
// it is possible to be having common drive method logic
// but not present in base class vehicle so this will leads to
// code duplication and hence we need strategy dp

interface DriveStrategy{
    public void drive();
}
class NormalDriveStrategy implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("Normal driving >>>>>>>>");
    }
}
class SportDriveStrategy implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("Special driving >>>>>>");
    }
}

class ImproveVehicle{
    private DriveStrategy driveStrategy;

    public ImproveVehicle(DriveStrategy driveStrategy) {
        this.driveStrategy = driveStrategy;
    }
    public void drive(){
        this.driveStrategy.drive();;
    }
}

class ImprovedSportyVehicle extends ImproveVehicle{

    public ImprovedSportyVehicle() {
        super(new SportDriveStrategy());
    }
}
class ImprovedOffRoadVehicle extends ImproveVehicle{
    public ImprovedOffRoadVehicle() {
        super(new SportDriveStrategy());
    }
}
class ImprovedPassengerVehicle extends ImproveVehicle{
    public ImprovedPassengerVehicle() {
        super(new NormalDriveStrategy());
    }
    // will reuse the parent class drive method
}

public class StrategyDesignPatternClientDemo {
    public static void main(String[] args) {
        ImprovedSportyVehicle improvedSportyVehicle = new ImprovedSportyVehicle();
        ImprovedOffRoadVehicle improvedOffRoadVehicle = new ImprovedOffRoadVehicle();
        ImprovedPassengerVehicle improvedPassengerVehicle = new ImprovedPassengerVehicle();
        improvedSportyVehicle.drive();
        improvedOffRoadVehicle.drive();
        improvedPassengerVehicle.drive();
    }
}
