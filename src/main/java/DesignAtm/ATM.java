package DesignAtm;

public class ATM {
    private static final ATM atmObject = new ATM();// Singleton:eager initialisation
    private ATMState atmState;
    private int atmBalance;
    private int numberOfTwoThousandNotes;
    private int numberOfFiveHundredNotes;
    private int numberOfTwoHundredNotes;

    private ATM() {

    }

    public static ATM getAtmObject() {
        atmObject.setCurrentATMState(new IdleState());
        return ATM.atmObject;
    }

    public void setCurrentATMState(ATMState atmState) {
        this.atmState = atmState;
    }

    public ATMState getCurrentATMState() {
        return this.atmState;
    }

    public ATMState getAtmState() {
        return this.atmState;
    }

    public int getAtmBalance() {
        return atmBalance;
    }

    public void setAtmBalance(int atmBalance, int numberOfTwoThousandNotes, int numberOfFiveHundredNotes,
                              int numberOfTwoHundredNotes) {
        this.atmBalance = atmBalance;
        this.numberOfTwoThousandNotes = numberOfTwoThousandNotes;
        this.numberOfFiveHundredNotes = numberOfFiveHundredNotes;
        this.numberOfTwoHundredNotes = numberOfTwoHundredNotes;
    }

    public int getNumberOfTwoThousandNotes() {
        return this.numberOfTwoThousandNotes;
    }

    public int getNumberOfFiveHundredNotes() {
        return this.numberOfFiveHundredNotes;
    }

    public int getNumberOfTwoHundredNotes() {
        return this.numberOfTwoHundredNotes;
    }

    public void deductATMBalance(int amount) {
        this.atmBalance -= amount;
    }

    public void deductTwoThousandNotes(int number) {
        this.numberOfTwoThousandNotes -= number;
    }

    public void deductTwoHundredNotes(int number) {
        this.numberOfTwoHundredNotes -= number;
    }

    public void deductFiveHundredNotes(int number) {
        this.numberOfFiveHundredNotes -= number;
    }

    public void printCurrentATMStates() {
        System.out.println("Balance:" + atmBalance);
        System.out.println("2kNotes: " + this.getNumberOfTwoThousandNotes());
        System.out.println("500Notes: " + this.numberOfFiveHundredNotes);
        System.out.println("100Notes: " + this.getNumberOfTwoHundredNotes());
    }

}
