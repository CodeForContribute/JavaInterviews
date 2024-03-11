package DesignAtm;

public class BankAccount {
    private int bankBalance;
    public void withdrawalBalance(int amount){
        this.bankBalance -= amount;
    }

    public int getBankBalance() {
        return bankBalance;
    }

    public void setBankBalance(int bankBalance) {
        this.bankBalance = bankBalance;
    }
}
