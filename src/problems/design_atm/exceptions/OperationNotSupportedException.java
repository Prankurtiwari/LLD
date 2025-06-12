package problems.design_atm.exceptions;

public class OperationNotSupportedException extends RuntimeException {
    public OperationNotSupportedException(String message) {
        super(message);
    }
}
