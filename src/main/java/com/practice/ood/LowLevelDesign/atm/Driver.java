package com.practice.ood.LowLevelDesign.atm;

public class Driver {
    /*
    * ATM does the following things generally
    * 1. Check balance.
    * 2. Transfer the money from account a to account b.
    * 3. Cash Withdrawal.
    * 4. Cheque Deposit.
    * 5. Cash deposit.
    * 6. Print receipt.
    * 7. Show the balance & options for all the above activities on the screen.
    *
    * actors
    * 1. Operator
    *   a. Turning on/off using the designated key-switch.
    *   b. Refilling the ATM with Cash
    *   c. Refilling the ATM's printer with receipts
    *   d. Refilling the ATM's printer with ink.
    *   e. Take out deposited cash & checks to the bank branch associated to this ATM
    * 2. Customer
    *   a. Balance enquiry - the user can view his account balance.
    *   b. Cash Withdrawal
    *   c. Deposit funds/cash
    *   d. Deposit cheque
    *   e. Transfer funds from the user's account to some other user's account.
    * 3. Bank Manager
    *   a. Generate report to check total deposits
    *   b. Generate a report to check total Withdrawals.
    *   c. Generate total deposits/Withdrawals.
    *   d. Check the remaining cash in the ATM.
    *   e. Check the log of the ATM machine or security footage.
    *
    *
    * Main components of ATM - which interacts between ATM and users.
    * 1. Card Reader - to read the user's atm cards.
    * 2. KeyPad - to enter informations into the ATM e.g, PIN,Cards
    * 3. Screen - to display message to users.
    * 4 . Cash Dispenser - for dispensing cash.
    * 5. Printer - to print receipts
    * 6. Communication/Network infra
    * */
    public static void main(String[] args) {
        Bank bank = new Bank();
        ATM atm = new ATM();
        Customer customer = new Customer();
        Transaction transaction = new Transaction();
        atm.authenticateUser(customer);
        atm.makeTransaction(customer,transaction);

    }
}
