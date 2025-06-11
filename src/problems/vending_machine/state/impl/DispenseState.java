package problems.vending_machine.state.impl;

import problems.vending_machine.enums.Coin;
import problems.vending_machine.exceptions.OperationNotSupportedException;
import problems.vending_machine.model.Item;
import problems.vending_machine.model.VendingMachine;
import problems.vending_machine.state.State;

public class DispenseState implements State {

    DispenseState(VendingMachine machine, int codeNumber) throws Exception {

        System.out.println("Currently Vending machine is in DispenseState");
        dispenseProduct(machine, codeNumber);
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {

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
        throw new OperationNotSupportedException("operation not supported");
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int codeNumber) throws Exception {
        System.out.println("Product has been dispensed");
        Item item = machine.getInventory().getItem(codeNumber);
        machine.getInventory().updateSoldOutItem(codeNumber);
        machine.setState(new IdleState(machine));
        return item;

    }

    @Override
    public void refundFullMoney(VendingMachine machine) throws Exception {
        throw new OperationNotSupportedException("operation not supported");
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {

    }
}
