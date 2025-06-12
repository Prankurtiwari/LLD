package problems.design_atm.state.impl;

import problems.design_atm.models.Atm;
import problems.design_atm.models.Card;
import problems.design_atm.state.State;

public class HasCardState extends State {
    public HasCardState() {
        System.out.println("Card Inserted, Now system is in Has Card State");
    }
    @Override
    public void authenticatePin(Atm atm, Card card, int pin){
        boolean isCorrectPinEntered = card.isCorrectPINEntered(pin);

        if(isCorrectPinEntered) {
            atm.setAtmState(new SelectOperationState());
        } else {
            System.out.println("Invalid PIN Number");
            exit(atm);
        }
    }

    @Override
    public void exit(Atm atm){
        returnCard();
        atm.setAtmState(new IdleState());
        System.out.println("Exit happens");
    }

    @Override
    public void returnCard(){
        System.out.println("Please collect your card");
    }


}
