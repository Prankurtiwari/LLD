package problems.design_atm.processor;

import problems.design_atm.models.Atm;

public abstract class CashWithdrawProcessor {
    CashWithdrawProcessor nextProcessor;

    public CashWithdrawProcessor(CashWithdrawProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    public void withdraw(Atm atm, int remainingAmount) {
        if(nextProcessor != null) {
            nextProcessor.withdraw(atm, remainingAmount);
        }
    }

}
