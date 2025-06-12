package problems.design_atm.models;

public class UserBankAccount {
    private int balance;

    public UserBankAccount(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void withdrawBalance(int balance) {
        this.balance -= balance;
    }
}
