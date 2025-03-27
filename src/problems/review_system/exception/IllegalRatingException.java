package problems.review_system.exception;

public class IllegalRatingException extends RuntimeException{
    public IllegalRatingException(String message) {
        super(message);
    }
}
