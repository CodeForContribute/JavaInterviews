package DesignAtm;

public class User {
    private Card card;
    private BankAccount bankAccount;
    public Card getCard(){
        return this.card;
    }
    public void setCard(Card card){
        this.card = card;
    }
}
