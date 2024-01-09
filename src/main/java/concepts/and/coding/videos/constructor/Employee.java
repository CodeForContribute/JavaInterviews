package concepts.and.coding.videos.constructor;

public class Employee {
    private int employeeId;

    public Employee(int employeeId){
        this.employeeId = employeeId;
    }
    public Employee employee(int employeeId){
        this.employeeId = employeeId;
        return this;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public static void main(String[] args) {
        Employee employee = new Employee(1);
        System.out.println(employee.getEmployeeId());

    }
}
