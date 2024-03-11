package DesignAtm;

public class OneHundredWithdrawProcessor extends CashWithdrawalProcessor{
    public OneHundredWithdrawProcessor(CashWithdrawalProcessor nextCashWithdrawalProcessor) {
        super(nextCashWithdrawalProcessor);
    }

    @Override
    public void withDraw(ATM atm, int remainingAmount) {
        int required = remainingAmount / 100;
        int balance = remainingAmount % 100;
        if (required <= atm.getNumberOfTwoHundredNotes()){
            atm.deductTwoHundredNotes(required);
        }else if(required > atm.getNumberOfTwoHundredNotes()){
            atm.deductTwoHundredNotes(atm.getNumberOfTwoHundredNotes());
            balance += (required - atm.getNumberOfTwoHundredNotes())*100;
        }

        if (balance != 0){
            System.out.println("Something went wrong");
        }
    }
}
