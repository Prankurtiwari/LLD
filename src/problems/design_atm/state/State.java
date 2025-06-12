package problems.design_atm.state;

import problems.design_atm.enums.TransactionType;
import problems.design_atm.exceptions.OperationNotSupportedException;
import problems.design_atm.models.Atm;
import problems.design_atm.models.Card;

public abstract class State {
    public void insertCard(Atm atm, Card card) {
      throw new  OperationNotSupportedException("OOPS!! Something went wrong");
    }

    public void authenticatePin(Atm atm, Card card, int pin){
      throw new  OperationNotSupportedException("OOPS!! Something went wrong");
    }

    public void selectOperation(Atm atm, Card card, TransactionType txnType){
      throw new  OperationNotSupportedException("OOPS!! Something went wrong");
    }

    public void cashWithdrawal(Atm atm, Card card, int withdrawAmount){
      throw new  OperationNotSupportedException("OOPS!! Something went wrong");
    }

    public void displayBalance(Atm atm, Card card){
      throw new  OperationNotSupportedException("OOPS!! Something went wrong");
    }

    public void returnCard(){
      throw new  OperationNotSupportedException("OOPS!! Something went wrong");
    }

    public void exit(Atm atm){
      throw new  OperationNotSupportedException("OOPS!! Something went wrong");
    }

}
