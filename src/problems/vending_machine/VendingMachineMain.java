package problems.vending_machine;

import problems.vending_machine.enums.Coin;
import problems.vending_machine.enums.ItemType;
import problems.vending_machine.model.Item;
import problems.vending_machine.model.ItemShelf;
import problems.vending_machine.model.VendingMachine;
import problems.vending_machine.state.State;

public class VendingMachineMain {
    public static void main(String[] args) {
        VendingMachine vendingMachine = VendingMachine.getVendingMachineObject();
        try {

            System.out.println("|");
            System.out.println("filling up the inventory");
            System.out.println("|");

            fillUpInventory(vendingMachine);
            displayInventory(vendingMachine);

            System.out.println("|");
            System.out.println("clicking on InsertCoinButton");
            System.out.println("|");

            State vendingState = vendingMachine.getState();
            vendingState.clickOnInsertCoinButton(vendingMachine);

            vendingState = vendingMachine.getState();
            vendingState.insertCoin(vendingMachine, Coin.QUARTER);
            vendingState.insertCoin(vendingMachine, Coin.QUARTER);

            System.out.println("|");
            System.out.println("clicking on ProductSelectionButton");
            System.out.println("|");
            vendingState.clickOnStartProductSelectionButton(vendingMachine);

            vendingState = vendingMachine.getState();
            vendingState.chooseProduct(vendingMachine, 102);

            displayInventory(vendingMachine);

        }
        catch (Exception e){
            e.printStackTrace();
            displayInventory(vendingMachine);
        }


    }

    private static void fillUpInventory(VendingMachine vendingMachine){
        ItemShelf[] slots = vendingMachine.getInventory().getItemSelves();
        for (int i = 0; i < slots.length; i++) {
            Item newItem = new Item();
            if(i<3) {
                newItem.setItemType(ItemType.COKE);
                newItem.setPrice(12);
            }else if(i<5){
                newItem.setItemType(ItemType.PEPSI);
                newItem.setPrice(9);
            }else if(i<7){
                newItem.setItemType(ItemType.JUICE);
                newItem.setPrice(13);
            }else if(i<10){
                newItem.setItemType(ItemType.SODA);
                newItem.setPrice(7);
            }
            slots[i].setItem(newItem);
            slots[i].setSoldOut(false);
        }

    }

    private static void displayInventory(VendingMachine vendingMachine){

        ItemShelf[] slots = vendingMachine.getInventory().getItemSelves();
        for (ItemShelf slot : slots) {

            System.out.println("CodeNumber: " + slot.getCode() +
                    " Item: " + slot.getItem().getItemType().name() +
                    " Price: " + slot.getItem().getPrice() +
                    " isAvailable: " + !slot.isSoldOut());
        }
    }

}
