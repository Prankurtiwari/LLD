package problems.splitwise.service;

import problems.splitwise.model.Split;

import java.util.List;

public interface ExpenseSplit {

    void validateSplitRequest(List<Split> splitList, double totalAmount);
}
