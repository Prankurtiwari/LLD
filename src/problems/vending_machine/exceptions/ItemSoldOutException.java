package problems.vending_machine.exceptions;

public class ItemSoldOutException extends RuntimeException {
    public ItemSoldOutException(String message) {
        super(message);
    }
}
