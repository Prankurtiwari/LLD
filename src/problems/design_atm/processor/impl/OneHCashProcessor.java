package problems.design_atm.processor.impl;

import problems.design_atm.models.Atm;
import problems.design_atm.processor.CashWithdrawProcessor;

public class OneHCashProcessor extends CashWithdrawProcessor {

    private static final int CONST_AMOUNT = 100;
    public OneHCashProcessor(CashWithdrawProcessor nextProcessor) {
        super(nextProcessor);
    }

    @Override
    public void withdraw(Atm atm, int remainingAmount) {
        int required = remainingAmount / CONST_AMOUNT;
        int balance = remainingAmount % CONST_AMOUNT;

        if(required <= atm.getNoOfOneHNotes()) {
            atm.deductOneHundredNotes(required);
        } else if (required > atm.getNoOfOneHNotes()) {
            atm.deductOneHundredNotes(atm.getNoOfOneHNotes());
            balance += (required - atm.getNoOfOneHNotes()) * CONST_AMOUNT;
        }

        if (balance != 0) {
            super.withdraw(atm, balance);
        }
    }
}
