package DesignAtm;

public abstract class CashWithdrawalProcessor {
    private final CashWithdrawalProcessor nextCashWithdrawalProcessor;
    public CashWithdrawalProcessor(CashWithdrawalProcessor nextCashWithdrawalProcessor){
        this.nextCashWithdrawalProcessor = nextCashWithdrawalProcessor;
    }
    public void withDraw(ATM atm,int remainingAmount){
        if (nextCashWithdrawalProcessor != null){
            nextCashWithdrawalProcessor.withDraw(atm,remainingAmount);
        }
    }
}
