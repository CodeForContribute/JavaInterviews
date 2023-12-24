package concepts.and.coding.videos.constructor;

public class Employee {
    private int employeeId;

    public Employee(int employeeId){
        this.employeeId = employeeId;
    }
    public Employee Employee(int employeeId){
        this.employeeId = employeeId;
        return this;
    }
}
