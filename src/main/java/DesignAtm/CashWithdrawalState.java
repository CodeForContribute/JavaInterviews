package DesignAtm;

public class CashWithdrawalState extends ATMState{
    public CashWithdrawalState(){
        System.out.println("Please enter the withdrawal Amount.");
    }
    @Override
    public void cashWithdrawal(ATM atm, Card card,int withdrawalAmount){
        if (atm.getAtmBalance() < withdrawalAmount){
            System.out.println("Insufficient fund in the ATM Machine");
            exit(atm);
        }else if(card.getBankBalance() < withdrawalAmount){
            System.out.println("Insufficient fund in your bank account");
            exit(atm);
        }else {
            card.deductBankBalance(withdrawalAmount);
            atm.deductATMBalance(withdrawalAmount);
            // using chain of responsibility for this topic
            // how many 2k, 500Rs,100 Rs
            //CashWithdrawalProcessor withdrawalProcessor =
            exit(atm);
        }
    }
    public void exit(ATM atm){
        returnCard();
        atm.setCurrentATMState(new IdleState());
        System.out.println("Exit happens");
    }
    public void returnCard(){
        System.out.println("Please collect your card");
    }
}
