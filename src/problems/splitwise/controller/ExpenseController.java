package problems.splitwise.controller;

import problems.splitwise.enums.ExpenseSplitType;
import problems.splitwise.factory.SplitFactory;
import problems.splitwise.model.Expense;
import problems.splitwise.model.Split;
import problems.splitwise.model.User;
import problems.splitwise.service.ExpenseSplit;

import java.util.List;

public class ExpenseController {

    BalanceSheetController balanceSheetController;

    public static ExpenseController expenseController;

    private ExpenseController() {
        balanceSheetController = BalanceSheetController.getInstance();
    }

    public static ExpenseController getInstance() {
        if(expenseController == null) {
            synchronized (ExpenseController.class) {
                if (expenseController == null) {
                    expenseController = new ExpenseController();
                }
            }
        }
        return expenseController;
    }

    public Expense createExpense(String expenseId, String description, double expenseAmount,
                                 List<Split> splitDetails, ExpenseSplitType splitType, User paidByUser) {

        ExpenseSplit expenseSplit = SplitFactory.getSplitObject(splitType);
        expenseSplit.validateSplitRequest(splitDetails, expenseAmount);

        Expense expense = new Expense(expenseId, expenseAmount, description, paidByUser, splitType, splitDetails);

        balanceSheetController.updateUserExpenseBalanceSheet(paidByUser, splitDetails, expenseAmount);

        return expense;
    }
}
