package problems.splitwise.model;

import problems.splitwise.controller.ExpenseController;
import problems.splitwise.enums.ExpenseSplitType;

import java.util.ArrayList;
import java.util.List;

public class Group {

    String groupId;
    String groupName;
    List<User> groupMembers;

    List<Expense> expenseList;

    ExpenseController expenseController;

    public Group() {
        groupMembers = new ArrayList<>();
        expenseList = new ArrayList<>();
        expenseController = ExpenseController.getInstance();
    }

    //add member to group
    public void addMember(User member) {
        groupMembers.add(member);
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void createExpense(String expenseId, String description, double expenseAmount,
                              List<Split> splitDetails, ExpenseSplitType splitType, User paidByUser) {

        Expense expense = expenseController.createExpense(expenseId, description, expenseAmount, splitDetails, splitType, paidByUser);
        expenseList.add(expense);
    }
}
