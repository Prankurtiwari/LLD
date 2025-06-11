package problems.vending_machine.state.impl;

import problems.vending_machine.enums.Coin;
import problems.vending_machine.exceptions.OperationNotSupportedException;
import problems.vending_machine.model.Item;
import problems.vending_machine.model.VendingMachine;
import problems.vending_machine.state.State;

import java.util.ArrayList;

public class IdleState implements State {


    public IdleState() {
        System.out.println("Currently Machine is in ideal state");
    }

    public IdleState(VendingMachine machine) {
        System.out.println("Currently Machine is in ideal state");
        machine.setCoinList(new ArrayList<>());
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
        System.out.println("press insert coin");
        machine.setState(new HasMoneyState());
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {

    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {

    }

    @Override
    public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {

    }

    @Override
    public void getChange(int returnChangeMoney) throws Exception {
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new OperationNotSupportedException("operation not supported");
    }

    @Override
    public void refundFullMoney(VendingMachine machine) throws Exception {
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {
        machine.getInventory().addItem(item, codeNumber);
    }
}
