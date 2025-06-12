package problems.design_atm;

import problems.design_atm.enums.TransactionType;
import problems.design_atm.models.Atm;
import problems.design_atm.models.Card;
import problems.design_atm.models.User;
import problems.design_atm.models.UserBankAccount;

public class AtmRoomMain {
    private Atm atm;
    private User user;

    public static void main(String[] args) {
        AtmRoomMain atmRoomMain = new AtmRoomMain();
        atmRoomMain.initialize();

        atmRoomMain.atm.printCurrentATMStatus();
        atmRoomMain.atm.getAtmState().insertCard(atmRoomMain.atm, atmRoomMain.user.getCard());
        atmRoomMain.atm.getAtmState().authenticatePin(atmRoomMain.atm, atmRoomMain.user.getCard(), 112211);
        atmRoomMain.atm.getAtmState().selectOperation(atmRoomMain.atm, atmRoomMain.user.getCard(), TransactionType.CASH_WITHDRAW);
        atmRoomMain.atm.getAtmState().cashWithdrawal(atmRoomMain.atm, atmRoomMain.user.getCard(), 2700);
        atmRoomMain.atm.printCurrentATMStatus();

    }
    private void initialize() {
        atm = Atm.getAtmObject();
        atm.setAtmBalance(2000, 1,2,5);
        this.user = createUser();
    }

    private User createUser(){

        UserBankAccount bankAccount = createBankAccount();
        Card card = createCard(bankAccount);
        return new User(card, bankAccount);
    }

    private Card createCard(UserBankAccount bankAccount){
        return new Card(bankAccount);
    }

    private UserBankAccount createBankAccount() {
        return new UserBankAccount(3000);

    }



}
