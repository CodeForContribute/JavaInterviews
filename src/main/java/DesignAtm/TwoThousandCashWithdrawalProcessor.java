package DesignAtm;

public class TwoThousandCashWithdrawalProcessor extends CashWithdrawalProcessor{
    public TwoThousandCashWithdrawalProcessor(CashWithdrawalProcessor nextCashWithdrawalProcessor) {
        super(nextCashWithdrawalProcessor);
    }

    @Override
    public void withDraw(ATM atm, int remainingAmount) {
        int required = remainingAmount/2000;
        int balance = remainingAmount % 2000;
        if (required <= atm.getNumberOfTwoThousandNotes()){
            atm.deductTwoThousandNotes(required);
        }else if (required > atm.getNumberOfTwoThousandNotes()){
            atm.deductTwoThousandNotes(atm.getNumberOfTwoThousandNotes());
            balance = balance + (required - atm.getNumberOfTwoThousandNotes())*2000;
        }
        if (balance != 0){
            super.withDraw(atm, remainingAmount);
        }
    }
}
