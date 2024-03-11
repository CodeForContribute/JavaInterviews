package DesignAtm;

public class ATMRoom {
    private ATM atm;
    private User user;

    public static void main(String[] args) {
        ATMRoom atmRoom = new ATMRoom();
        atmRoom.initialize();
        atmRoom.atm.printCurrentATMStates();
        atmRoom.atm.getCurrentATMState().insertCard(atmRoom.atm, atmRoom.user.getCard());
        atmRoom.atm.getCurrentATMState().authenticatePin(atmRoom.atm, atmRoom.user.getCard(), 112211);
        atmRoom.atm.getCurrentATMState().selectOperation(atmRoom.atm, atmRoom.user.getCard(), TransactionType.CASH_WITHDRAWAL);
        atmRoom.atm.getCurrentATMState().cashWithdrawal(atmRoom.atm, atmRoom.user.getCard(), 2700);
        atmRoom.atm.printCurrentATMStates();
    }

    private void initialize() {
        this.atm = ATM.getAtmObject();
        this.atm.setAtmBalance(3500, 1, 2, 5);
        this.user = createUser();
    }

    private User createUser() {
        User user = new User();
        user.setCard(createCard());
        return user;
    }

    private Card createCard() {
        Card card = new Card();
        card.setBankAccount(createAccount());
        return card;
    }

    private BankAccount createAccount() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setBankBalance(3000);
        return bankAccount;
    }
}
