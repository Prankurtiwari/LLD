package problems.splitwise.factory;

import problems.splitwise.enums.ExpenseSplitType;
import problems.splitwise.exception.UnsupportedSplitException;
import problems.splitwise.service.ExpenseSplit;
import problems.splitwise.service.impl.EqualExpenseSplit;
import problems.splitwise.service.impl.PercentageExpenseSplit;
import problems.splitwise.service.impl.UnequalExpenseSplit;

public class SplitFactory {

    public static ExpenseSplit getSplitObject(ExpenseSplitType splitType) {
        return switch (splitType) {
            case EQUAL -> new EqualExpenseSplit();
            case UNEQUAL -> new UnequalExpenseSplit();
            case PERCENTAGE -> new PercentageExpenseSplit();
            default -> throw new UnsupportedSplitException("Split not supported");
        };
    }
}
