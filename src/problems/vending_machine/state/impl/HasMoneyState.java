package problems.vending_machine.state.impl;

import problems.vending_machine.enums.Coin;
import problems.vending_machine.exceptions.OperationNotSupportedException;
import problems.vending_machine.model.Item;
import problems.vending_machine.model.VendingMachine;
import problems.vending_machine.state.State;

public class HasMoneyState implements State {

    public HasMoneyState() {
        System.out.println("Currently Machine is in has money state");
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {
        machine.setState(new SelectionState());
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        machine.setState(new SelectionState());
        machine.getCoinList().add(coin);
        System.out.println("Machine accepted the coin");
    }

    @Override
    public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {

    }

    @Override
    public void getChange(int returnChangeMoney) throws Exception {
        throw new OperationNotSupportedException("operation not supported");
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new OperationNotSupportedException("operation not possible");
    }

    @Override
    public void refundFullMoney(VendingMachine machine) throws Exception {
       machine.setState(new IdleState(machine));
       System.out.println("Refund processed");
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {

    }
}
