package problems.design_atm.processor.impl;

import problems.design_atm.models.Atm;
import problems.design_atm.processor.CashWithdrawProcessor;

public class TwoKCashProcessor extends CashWithdrawProcessor {

    private static final int CONST_AMOUNT = 2000;
    public TwoKCashProcessor(CashWithdrawProcessor nextProcessor) {
        super(nextProcessor);
    }

    @Override
    public void withdraw(Atm atm, int remainingAmount) {
        int required = remainingAmount / CONST_AMOUNT;
        int balance = remainingAmount % CONST_AMOUNT;

        if(required <= atm.getNoOfTwoKNotes()) {
            atm.deductTwoThousandNotes(required);
        } else if (required > atm.getNoOfTwoKNotes()) {
            atm.deductTwoThousandNotes(atm.getNoOfTwoKNotes());
            balance += (required - atm.getNoOfTwoKNotes()) * CONST_AMOUNT;
        }

        if (balance != 0) {
            super.withdraw(atm, balance);
        }
    }
}
