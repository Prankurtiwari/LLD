package problems.book_my_show.enums;

public enum SeatStatus {
    BOOKED(10),
    AVAILABLE(20);

    private final int value;

    SeatStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
