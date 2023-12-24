package design.patterns.proxy;

import java.util.Date;
import java.util.UUID;

interface EmployeeDao {
    boolean create(String role, Employee employee);

    boolean delete(String role, UUID employeeId);

    boolean update(String role, UUID employeeId);
}

class Employee {
    private UUID employeeId;
    private String employeeName;
    private Date joiningDate;
}

class EmployeeDaoProxy implements EmployeeDao {
    private final EmployeeDao employeeDaoImpl;

    public EmployeeDaoProxy(EmployeeDao employeeDaoImpl) {
        this.employeeDaoImpl = employeeDaoImpl;
    }

    @Override
    public boolean create(String role, Employee employee) {
        boolean status = false;
        if (role.equalsIgnoreCase("admin")) {
            status = employeeDaoImpl.create(role, employee);
        } else {
            System.out.println("User does not have permission to create a new User");
        }
        return status;
    }

    @Override
    public boolean delete(String role,UUID employeeId) {
        boolean status = false;
        if (role.equalsIgnoreCase("admin")) {
            status = employeeDaoImpl.delete(role, employeeId);
        } else {
            System.out.println("User does not have permission to delete a User");
        }
        return status;
    }

    @Override
    public boolean update(String role,UUID employeeId) {
        boolean status = false;
        if (role.equalsIgnoreCase("admin")) {
            status = employeeDaoImpl.update(role, employeeId);
        } else {
            System.out.println("User does not have permission to update a User");
        }
        return status;
    }
}

class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public boolean create(String role, Employee employee) {
        System.out.println("Creating user >>> : {}" + employee.toString());
        return true;
    }

    @Override
    public boolean delete(String role, UUID employeeId) {
        System.out.println("Deleting user >>> : {}" + employeeId.toString());
        return true;
    }

    @Override
    public boolean update(String role, UUID employeeId) {
        System.out.println("Updating user >>> : {}" + employeeId.toString());
        return true;
    }
}

public class ProxyDesignPatternClientDemo {
    public static void main(String[] args) {
        try {
            EmployeeDao employeeDaoImpl = new EmployeeDaoImpl();
            EmployeeDao employeeDaoProxy = new EmployeeDaoProxy(employeeDaoImpl);
            boolean status = employeeDaoProxy.create("ADMIN", new Employee());
            if (status)System.out.println("Operation successful >>>>>>>>>>>>");
            else System.out.println("Operation unsuccessful >>>>>>>>>>>>");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
