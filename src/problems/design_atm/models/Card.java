package problems.design_atm.models;

public class Card {
    private int cardNumber;
    private int cvv;
    private int expiryDate;
    private int holderName;
    static int PIN_NUMBER = 112211;
    private UserBankAccount bankAccount;

    public Card(UserBankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public boolean isCorrectPINEntered(int pin) {
        return pin == PIN_NUMBER;
    }

    public int getBankBalance(){
        return bankAccount.getBalance();
    }

    public void deductBankBalance(int amount){
        bankAccount.withdrawBalance(amount);
    }

    public void setBankAccount(UserBankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }



}
