package com.practice.ood.LowLevelDesign.atm;

public class ATM {
    private int atmId;
    private Bank bank;
    private Address atmAddressLocation;
    private CashDispenser cashDispenser;
    private KeyPad keyPad;
    private Screen screen;
    private Printer printer;
    private ChequeDeposit chequeDeposit;
    private CashDeposit cashDeposit;
    private boolean isUserAuthenticated;

    public boolean authenticateUser(Customer customer){
        if (this.bank.isCustomerExist(customer)){
            isUserAuthenticated = true;
            return true;
        }else{
            isUserAuthenticated = false;
            return false;
        }

    }
    public TransactionStatus makeTransaction(Customer customer, Transaction transaction){
        TransactionStatus transactionStatus = null;
        if (isUserAuthenticated){
            if (transaction.equals(TransactionType.BALANCE_ENQUIRY)){
                Balance balance = this.bank.getBalance(customer,transaction);
                screen.showMessage(balance.toString());
                if (balance != null){
                    transactionStatus = TransactionStatus.SUCCESS;
                }else{
                    transactionStatus = TransactionStatus.FAILURE;
                }
            }else if (transaction.equals(TransactionType.CASH_WITHDRAWAL)){

            }
        }
        return transactionStatus;
    }

}
