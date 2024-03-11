package DesignAtm;

public class Card {
    private int cardNumber;
    private int cvv;
    private int expiryDate;
    private int holderName;
    private static final  int pinNumber = 112211;
    private BankAccount bankAccount;

    public boolean isCorrectPinEntered(int pin){
        if (pinNumber == pin){
            return true;
        }
        return false;
    }
    public int getBankBalance(){
        return this.bankAccount.getBankBalance();
    }

    public void deductBankBalance(int amount){
        this.bankAccount.withdrawalBalance(amount);
    }
    public void setBankAccount(BankAccount bankAccount){
        this.bankAccount = bankAccount;
    }
}
