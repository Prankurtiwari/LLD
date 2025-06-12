package problems.design_atm.models;

import problems.design_atm.state.State;
import problems.design_atm.state.impl.IdleState;

public class Atm {

    private static volatile Atm atm;

    State atmState;

    private int atmBalance;
    private int noOfTwoKNotes;
    private int noOfFiveHNotes;

    private int noOfOneHNotes;

    private Atm()  {
        this.atmState =  new IdleState();
    }

    public static Atm getAtmObject() {
        if(atm == null) {
            synchronized (Atm.class){
                if(atm == null) {
                    atm = new Atm();
                }
            }
        }
        return atm;
    }

    public State getAtmState() {
        return atmState;
    }

    public void setAtmState(State atmState) {
        this.atmState = atmState;
    }

    public int getAtmBalance() {
        return atmBalance;
    }

    public void setAtmBalance(int atmBalance, int noOfTwoKNotes, int noOfFiveHNotes, int noOfOneHKNotes) {
        this.atmBalance = atmBalance;
        this.noOfTwoKNotes = noOfTwoKNotes;
        this.noOfFiveHNotes = noOfFiveHNotes;
        this.noOfOneHNotes = noOfOneHKNotes;
    }

    public int getNoOfTwoKNotes() {
        return noOfTwoKNotes;
    }

    public void setNoOfTwoKNotes(int noOfTwoKNotes) {
        this.noOfTwoKNotes = noOfTwoKNotes;
    }

    public int getNoOfFiveHNotes() {
        return noOfFiveHNotes;
    }

    public void setNoOfFiveHNotes(int noOfFiveHNotes) {
        this.noOfFiveHNotes = noOfFiveHNotes;
    }

    public int getNoOfOneHNotes() {
        return noOfOneHNotes;
    }

    public void setNoOfOneHNotes(int noOfOneHNotes) {
        this.noOfOneHNotes = noOfOneHNotes;
    }

    public void deductTwoThousandNotes(int number) {
        noOfTwoKNotes = noOfTwoKNotes - number;
    }

    public void deductFiveHundredNotes(int number) {
        noOfFiveHNotes = noOfFiveHNotes - number;
    }

    public void deductOneHundredNotes(int number) {
        noOfOneHNotes = noOfOneHNotes - number;
    }

    public void deductATMBalance(int amount) {
        atmBalance -= amount;
    }

    public void printCurrentATMStatus(){
        System.out.println("Balance: " + atmBalance);
        System.out.println("2kNotes: " + noOfTwoKNotes);
        System.out.println("500Notes: " + noOfFiveHNotes);
        System.out.println("100Notes: " + noOfOneHNotes);

    }

}
