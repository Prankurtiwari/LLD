package problems.book_my_show.exception;

public class SeatAlreadyBookedException extends RuntimeException{
    public SeatAlreadyBookedException(String message) {
        super(message);
    }
}
