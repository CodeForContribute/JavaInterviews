package com.practice.ood.LowLevelDesign.atm;

public class Customer {
    private Integer customerId;
    private String customerFirstName;
    private String customerLastName;
    private String customerEmailAddress;
    private Address customerAddress;
    private CustomerStatus customerStatus = CustomerStatus.ACTIVE;
    private BankAccount account;
}
