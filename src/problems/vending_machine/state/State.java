package problems.vending_machine.state;

import problems.vending_machine.enums.Coin;
import problems.vending_machine.model.Item;
import problems.vending_machine.model.VendingMachine;

public interface State {
    void clickOnInsertCoinButton(VendingMachine machine) throws Exception;

    void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception;

    void insertCoin(VendingMachine machine, Coin coin) throws Exception;

    void chooseProduct(VendingMachine machine, int codeNumber) throws Exception;

    void getChange(int returnChangeMoney) throws Exception;

    Item dispenseProduct(VendingMachine machine, int codeNumber) throws Exception;

    void refundFullMoney(VendingMachine machine) throws Exception;

    void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception;

}
