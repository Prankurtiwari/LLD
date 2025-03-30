package problems.book_my_show.enums;

public enum SeatType {
    SILVER(10),
    GOLD(20),
    DIAMOND(30);

    private final int value;

    SeatType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
