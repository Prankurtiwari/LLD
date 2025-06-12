package problems.design_atm.processor.impl;

import problems.design_atm.models.Atm;
import problems.design_atm.processor.CashWithdrawProcessor;

public class FiveHCashProcessor extends CashWithdrawProcessor {

    private static final int CONST_AMOUNT = 500;
    public FiveHCashProcessor(CashWithdrawProcessor nextProcessor) {
        super(nextProcessor);
    }

    @Override
    public void withdraw(Atm atm, int remainingAmount) {
        int required = remainingAmount / CONST_AMOUNT;
        int balance = remainingAmount % CONST_AMOUNT;

        if(required <= atm.getNoOfFiveHNotes()) {
            atm.deductFiveHundredNotes(required);
        } else if (required > atm.getNoOfFiveHNotes()) {
            atm.deductFiveHundredNotes(atm.getNoOfFiveHNotes());
            balance += (required - atm.getNoOfFiveHNotes()) * CONST_AMOUNT;
        }

        if (balance != 0) {
            super.withdraw(atm, balance);
        }
    }
}
