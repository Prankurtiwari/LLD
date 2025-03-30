package problems.book_my_show.enums;

public enum City {
    VARANASI(10),
    DELHI(20);

    private final int value;

    City(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
