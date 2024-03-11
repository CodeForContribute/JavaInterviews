package DesignAtm;

public class HasCardState extends ATMState{
    public HasCardState() {
        System.out.println("enter your card ping number");
    }

    @Override
    public void authenticatePin(ATM atm, Card card, int pin) {
        boolean isCorrectedPinEntered = card.isCorrectPinEntered(pin);
        if (isCorrectedPinEntered){
            atm.setCurrentATMState(new SelectOperationState());
        }else{
            System.out.println("InValid pin number");
            exit(atm);
        }
    }

    @Override
    public void returnCard() {
        System.out.println("Please collect your card");
    }

    @Override
    public void exit(ATM atm) {
        returnCard();
        atm.setCurrentATMState(new IdleState());
        System.out.println("Exit happens");
    }
}
