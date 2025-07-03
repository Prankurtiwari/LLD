package problems.splitwise.service.impl;

import problems.splitwise.model.Split;
import problems.splitwise.service.ExpenseSplit;

import java.util.List;

public class EqualExpenseSplit implements ExpenseSplit {

    @Override
    public void validateSplitRequest(List<Split> splitList, double totalAmount) {

        //validate total amount in splits of each user is equal and overall equals to totalAmount or not
        double amountShouldBePresent = totalAmount/splitList.size();
        for(Split split: splitList) {
           if(split.getAmountOwe() != amountShouldBePresent) {
               //throw exception
           }
        }
    }
}
