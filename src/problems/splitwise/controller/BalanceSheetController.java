package problems.splitwise.controller;

import problems.splitwise.model.Balance;
import problems.splitwise.model.Split;
import problems.splitwise.model.User;
import problems.splitwise.model.UserExpenseBalanceSheet;

import java.util.List;
import java.util.Map;

public class BalanceSheetController {

    UserController userController;
    private static BalanceSheetController balanceSheetController;
    private BalanceSheetController() {
        userController = UserController.getInstance();
    }

    public static BalanceSheetController getInstance() {
        if(balanceSheetController == null) {
            synchronized (BalanceSheetController.class) {
                if (balanceSheetController == null) {
                    balanceSheetController = new BalanceSheetController();
                }
            }
        }
        return balanceSheetController;
    }

    public void updateUserExpenseBalanceSheet(User expensePaidBy, List<Split> splits, double totalExpenseAmount){

        //update the total amount paid of the expense paid by user
        UserExpenseBalanceSheet paidByUserExpenseSheet = expensePaidBy.getUserExpenseBalanceSheet();
        paidByUserExpenseSheet.setTotalPayment(paidByUserExpenseSheet.getTotalPayment() + totalExpenseAmount);

        for(Split split : splits) {

            User userOwe = split.getUser();
            UserExpenseBalanceSheet oweUserExpenseSheet = userOwe.getUserExpenseBalanceSheet();
            double oweAmount = split.getAmountOwe();

            if(expensePaidBy.getId().equals(userOwe.getId())){
                paidByUserExpenseSheet.setTotalYourExpense(paidByUserExpenseSheet.getTotalYourExpense()+oweAmount);
            }
            else {

                //update the balance of paid user
                paidByUserExpenseSheet.setTotalYouGetBack(paidByUserExpenseSheet.getTotalYouGetBack() + oweAmount);

                Balance userOweBalance;
                if(paidByUserExpenseSheet.getUserVsBalance().containsKey(userOwe.getId())) {

                    userOweBalance = paidByUserExpenseSheet.getUserVsBalance().get(userOwe.getId());
                }
                else {
                    userOweBalance = new Balance();
                    paidByUserExpenseSheet.getUserVsBalance().put(userOwe.getId(), userOweBalance);
                }

                userOweBalance.setAmountGetBack(userOweBalance.getAmountGetBack() + oweAmount);


                //update the balance sheet of owe user
                oweUserExpenseSheet.setTotalYouOwe(oweUserExpenseSheet.getTotalYouOwe() + oweAmount);
                oweUserExpenseSheet.setTotalYourExpense(oweUserExpenseSheet.getTotalYourExpense() + oweAmount);

                Balance userPaidBalance;
                if(oweUserExpenseSheet.getUserVsBalance().containsKey(expensePaidBy.getId())){
                    userPaidBalance = oweUserExpenseSheet.getUserVsBalance().get(expensePaidBy.getId());
                }
                else{
                    userPaidBalance = new Balance();
                    oweUserExpenseSheet.getUserVsBalance().put(expensePaidBy.getId(), userPaidBalance);
                }
                userPaidBalance.setAmountOwe(userPaidBalance.getAmountOwe() + oweAmount);
            }
        }
    }

    public void showBalanceSheetOfUser(User user){

        System.out.println("---------------------------------------");

        System.out.println("Balance sheet of user : " + user.getName());

        UserExpenseBalanceSheet userExpenseBalanceSheet =  user.getUserExpenseBalanceSheet();

        System.out.println("TotalYourExpense: " + userExpenseBalanceSheet.getTotalYourExpense());
        System.out.println("TotalGetBack: " + userExpenseBalanceSheet.getTotalYouGetBack());
        System.out.println("TotalYourOwe: " + userExpenseBalanceSheet.getTotalYouOwe());
        System.out.println("TotalPaymentMade: " + userExpenseBalanceSheet.getTotalPayment());
        for(Map.Entry<String, Balance> entry : userExpenseBalanceSheet.getUserVsBalance().entrySet()){

            String userID = entry.getKey();
            Balance balance = entry.getValue();

            System.out.println("user name:" + userController.getUser(userID).getName() + " YouGetBack:" + balance.getAmountGetBack() + " YouOwe:" + balance.getAmountOwe());
        }

        System.out.println("---------------------------------------");

    }
}
