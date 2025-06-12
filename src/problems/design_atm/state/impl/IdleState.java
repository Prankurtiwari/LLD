package problems.design_atm.state.impl;

import problems.design_atm.models.Atm;
import problems.design_atm.models.Card;
import problems.design_atm.state.State;

public class IdleState extends State {
    public IdleState() {
        System.out.println("ATM is in idle state");
    }

    @Override
    public void insertCard(Atm atm, Card card) {
        System.out.println("Card is Inserted");
        atm.setAtmState(new HasCardState());
    }
}
