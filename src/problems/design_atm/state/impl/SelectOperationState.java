package problems.design_atm.state.impl;

import problems.design_atm.enums.TransactionType;
import problems.design_atm.models.Atm;
import problems.design_atm.models.Card;
import problems.design_atm.state.State;

public class SelectOperationState extends State {
    public SelectOperationState() {
        System.out.println("Machine is in Operation Selection state. Please select the Operation");
        TransactionType.showAllTransactionType();
    }

    @Override
    public void selectOperation(Atm atmObject, Card card, TransactionType txnType){

        switch (txnType) {

            case CASH_WITHDRAW:
                atmObject.setAtmState(new CashWithdrawalState());
                break;
            case BALANCE_CHECK:
                atmObject.setAtmState(new CheckBalanceState());
                break;
            default: {
                System.out.println("Invalid Option");
                exit(atmObject);
            }

        }
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
