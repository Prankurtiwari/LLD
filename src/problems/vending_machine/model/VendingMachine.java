package problems.vending_machine.model;

import problems.vending_machine.enums.Coin;
import problems.vending_machine.state.State;
import problems.vending_machine.state.impl.IdleState;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

    private static volatile VendingMachine vendingMachine;
    private Inventory inventory;
    private List<Coin> coinList;
    private State state;

    private VendingMachine() {
        state = new IdleState();
        inventory = new Inventory(10);
        coinList = new ArrayList<>();
    }

    public static VendingMachine getVendingMachineObject() {
        if (vendingMachine == null) {
            synchronized(VendingMachine.class)
            {
                if (vendingMachine == null) {
                    vendingMachine = new VendingMachine();
                }
            }
        }
        return vendingMachine;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public List<Coin> getCoinList() {
        return coinList;
    }

    public void setCoinList(List<Coin> coinList) {
        this.coinList = coinList;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
