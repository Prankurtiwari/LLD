package problems.design_atm.models;

public class User {
    Card card;
    UserBankAccount userBankAccount;

    public User(Card card, UserBankAccount userBankAccount) {
        this.card = card;
        this.userBankAccount = userBankAccount;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public UserBankAccount getUserBankAccount() {
        return userBankAccount;
    }

    public void setUserBankAccount(UserBankAccount userBankAccount) {
        this.userBankAccount = userBankAccount;
    }
}
