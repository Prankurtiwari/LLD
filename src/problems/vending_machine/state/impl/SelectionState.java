package problems.vending_machine.state.impl;

import problems.vending_machine.enums.Coin;
import problems.vending_machine.exceptions.InsufficientMoneyException;
import problems.vending_machine.exceptions.OperationNotSupportedException;
import problems.vending_machine.model.Item;
import problems.vending_machine.model.VendingMachine;
import problems.vending_machine.state.State;

public class SelectionState implements State {


    public SelectionState() {
        System.out.println("Currently machine is in Selection State");
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
        Item item = machine.getInventory().getItem(codeNumber);

        int paidByUser = 0;
        for(Coin coin: machine.getCoinList()) {
            paidByUser += coin.getValue();
        }

        if (paidByUser < item.getPrice()) {
            refundFullMoney(machine);
            throw new InsufficientMoneyException("Money not sufficient inserted by User");
        } else if (paidByUser >= item.getPrice()) {
            if(paidByUser > item.getPrice()) {
                getChange(paidByUser - item.getPrice());
            }
            machine.setState(new DispenseState(machine, codeNumber));
        }
    }

    @Override
    public void getChange(int returnChangeMoney) throws Exception {
        System.out.println("Returned the change in the Coin Dispense Tray: " + returnChangeMoney);
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new OperationNotSupportedException("operation not supported");
    }

    @Override
    public void refundFullMoney(VendingMachine machine) throws Exception {
        System.out.println("Returned the full amount back in the Coin Dispense Tray" + machine.getCoinList().stream().mapToInt(Coin::getValue).sum());
        machine.setState(new IdleState(machine));

    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {

    }
}
