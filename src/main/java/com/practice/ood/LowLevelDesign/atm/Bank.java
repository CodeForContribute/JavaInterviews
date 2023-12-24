package com.practice.ood.LowLevelDesign.atm;

import java.util.List;

import java.util.Map;

public class Bank {
    
    private Integer bankCode;
    
    private String bankName;
    
    private Address bankOfficialAddress;
    
    private List<BankBranch> branches;
    
    private Map<Integer,Integer> branchManagers;
    private List<ATM>bankAtmIds;
    
    private List<Customer>bankCustomers;

    public boolean isCustomerExist(Customer customer){
        return bankCustomers.contains(customer);
    }
    public boolean authenticateCustomer(Customer customer){
        return isCustomerExist(customer);
    }
    public boolean addCustomer(Customer customer){
        this.bankCustomers.add(customer);
        return this.bankCustomers.contains(customer);
    }

    public boolean removeCustomer(Customer customer){
        this.bankCustomers.remove(customer);
        return !this.bankCustomers.contains(customer);
    }
    public boolean addATM(ATM atm){
        this.bankAtmIds.add(atm);
        return this.bankAtmIds.contains(atm);
    }

    public void setBankCode(Integer bankCode) {
        this.bankCode = bankCode;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void setBankOfficialAddress(Address bankOfficialAddress) {
        this.bankOfficialAddress = bankOfficialAddress;
    }

    public void setBranches(List<BankBranch> branches) {
        this.branches = branches;
    }

    public void setBranchManagers(Map<Integer, Integer> branchManagers) {
        this.branchManagers = branchManagers;
    }

    public void setBankCustomers(List<Customer> bankCustomers) {
        this.bankCustomers = bankCustomers;
    }

    public Balance getBalance(Customer customer, Transaction transaction) {
        Balance balance = new Balance();
        return balance;
    }

    public Integer getBankCode() {
        return bankCode;
    }

    public String getBankName() {
        return bankName;
    }

    public Address getBankOfficialAddress() {
        return bankOfficialAddress;
    }

    public List<BankBranch> getBranches() {
        return branches;
    }

    public Map<Integer, Integer> getBranchManagers() {
        return branchManagers;
    }

    public List<ATM> getBankAtmIds() {
        return bankAtmIds;
    }

    public List<Customer> getBankCustomers() {
        return bankCustomers;
    }
}
