package problems.vending_machine.exceptions;

public class ItemAlreadyPresentException extends RuntimeException {
    public ItemAlreadyPresentException(String message) {
        super(message);
    }
}
