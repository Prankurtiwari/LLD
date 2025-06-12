package problems.design_atm.state.impl;

import problems.design_atm.models.Atm;
import problems.design_atm.models.Card;
import problems.design_atm.processor.CashWithdrawProcessor;
import problems.design_atm.processor.impl.FiveHCashProcessor;
import problems.design_atm.processor.impl.OneHCashProcessor;
import problems.design_atm.processor.impl.TwoKCashProcessor;
import problems.design_atm.state.State;
import problems.vending_machine.exceptions.OperationNotSupportedException;

public class CashWithdrawalState extends State {
    public CashWithdrawalState() {
        System.out.println("Machine is in cash Withdraw state. Please enter the Withdrawal Amount");
    }

    @Override
    public void cashWithdrawal(Atm atmObject, Card card, int withdrawalAmountRequest) {
        if (atmObject.getAtmBalance() < withdrawalAmountRequest) {
            exit(atmObject);
            throw new OperationNotSupportedException("Insufficient fund in the ATM Machine");
        } else if (card.getBankBalance() < withdrawalAmountRequest) {
            exit(atmObject);
            throw new OperationNotSupportedException("Insufficient fund in the your Bank Account");
        } else {
            card.deductBankBalance(withdrawalAmountRequest);
            atmObject.deductATMBalance(withdrawalAmountRequest);

            //using chain of responsibility for this logic, how many 2k Rs notes, how many 500 Rs notes etc, has to be withdrawal
            CashWithdrawProcessor withdrawProcessor =
                    new TwoKCashProcessor(new FiveHCashProcessor(new OneHCashProcessor(null)));

            withdrawProcessor.withdraw(atmObject, withdrawalAmountRequest);
            exit(atmObject);
        }

    }

    @Override
    public void returnCard() {
        System.out.println("Please collect your card");
    }

    @Override
    public void exit(Atm atm) {
        returnCard();
        atm.setAtmState(new IdleState());
        System.out.println("Exit happens");

    }
}
