package problems.vending_machine.model;

import problems.vending_machine.enums.ItemType;

public class Item {
    private ItemType itemType;
    private int price;

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
