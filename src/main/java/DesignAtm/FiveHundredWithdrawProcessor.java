package DesignAtm;

public class FiveHundredWithdrawProcessor extends CashWithdrawalProcessor{

    public FiveHundredWithdrawProcessor(CashWithdrawalProcessor cashWithdrawalProcessor){
        super(cashWithdrawalProcessor);
    }

    @Override
    public void withDraw(ATM atm, int remainingAmount) {
        int required = remainingAmount / 500;
        int balance = remainingAmount % 500;
        if (required <= atm.getNumberOfFiveHundredNotes()){
            atm.deductFiveHundredNotes(required);
        }else if (required > atm.getNumberOfFiveHundredNotes()){
            atm.deductFiveHundredNotes(atm.getNumberOfFiveHundredNotes());
            balance += (required - atm.getNumberOfFiveHundredNotes())*500;
        }
        if (balance != 0){
            super.withDraw(atm, remainingAmount);
        }
    }
}
