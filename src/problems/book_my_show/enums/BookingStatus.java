package problems.book_my_show.enums;

public enum BookingStatus {
    PENDING(10),
    CONFIRMED(20),
    CANCELLED(30);

    private final int value;

    BookingStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
