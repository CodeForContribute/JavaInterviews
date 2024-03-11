package DesignAtm;

public class SelectOperationState extends ATMState{
    public SelectOperationState(){
        showOperations();
    }

    @Override
    public void selectOperation(ATM atm, Card card, TransactionType transactionType) {
        switch (transactionType){
            case CASH_WITHDRAWAL:
                atm.setCurrentATMState(new CashWithdrawalState());
                break;
            case BALANCE_CHECK:
                atm.setCurrentATMState(new CheckBalanceCheckState());
                break;
            default:
                System.out.println("Invalid Option");
                exit(atm);
        }
    }

    @Override
    public void returnCard() {
        System.out.println("Please Collect your Card");
    }

    @Override
    public void exit(ATM atm) {
        returnCard();
        atm.setCurrentATMState(new IdleState());
        System.out.println("Exit happens");
    }

    public void showOperations(){
        System.out.println("Please select the operation");
        TransactionType.showAllTransactionTypes();
    }
}
