package problems.design_atm.state.impl;

import problems.design_atm.models.Atm;
import problems.design_atm.models.Card;
import problems.design_atm.state.State;

public class CheckBalanceState extends State {
    public CheckBalanceState() {
        System.out.println("ATM is in check balance state");
    }

    @Override
    public void displayBalance(Atm atm, Card card){
        System.out.println("Your Balance is: " + card.getBankBalance());
        exit(atm);
    }

    @Override
    public void exit(Atm atmObject){
        returnCard();
        atmObject.setAtmState(new IdleState());
        System.out.println("Exit happens");
    }

    @Override
    public void returnCard(){
        System.out.println("Please collect your card");
    }

}
