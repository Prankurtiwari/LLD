package problems.vending_machine.model;

import problems.vending_machine.exceptions.CodeNotFoundException;
import problems.vending_machine.exceptions.ItemAlreadyPresentException;
import problems.vending_machine.exceptions.ItemSoldOutException;

public class Inventory {
    ItemShelf[] itemSelves;

    public Inventory(int itemCount) {
        this.itemSelves = new ItemShelf[itemCount];
        initialEmptyInventory();
    }

    public ItemShelf[] getItemSelves() {
        return itemSelves;
    }

    public void setItemSelves(ItemShelf[] itemSelves) {
        this.itemSelves = itemSelves;
    }

    private void initialEmptyInventory() {
        int startCode = 101;
        for(int i =0;i< itemSelves.length;i++) {
            ItemShelf itemSelf = new ItemShelf();
            itemSelf.setCode(startCode);
            itemSelf.setSoldOut(true);
            itemSelves[i] = itemSelf;
            startCode++;
        }
    }

    public void addItem(Item item, int code) throws Exception{
        for (ItemShelf itemSelf : itemSelves) {
            if (itemSelf.getCode() == code) {
                if(itemSelf.isSoldOut()) {
                    itemSelf.setItem(item);
                    itemSelf.setSoldOut(false);
                } else {
                    throw new ItemAlreadyPresentException("Item already present. Try with other code");
                }
            } else {
                throw new CodeNotFoundException("Code not present try again with other code");
            }
        }
    }

    public Item getItem(int code) throws Exception{
        for(ItemShelf itemSelf : itemSelves)  {
            if(itemSelf.isSoldOut()) {
                throw new ItemSoldOutException("Item is sold Out");
            }
            return itemSelf.getItem();
        }
        throw new CodeNotFoundException("Code not present try again with other code");
    }

    public void updateSoldOutItem(int codeNumber){
        for (ItemShelf itemShelf : itemSelves) {
            if (itemShelf.getCode() == codeNumber) {
                itemShelf.setSoldOut(true);
                return;
            }
        }
        throw new CodeNotFoundException("Code not present try again with other code");
    }

}
