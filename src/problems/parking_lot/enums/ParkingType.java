package problems.parking_lot.enums;

public enum ParkingType {
    TWO_WHEEL_PARKING("two_wheeler_parking"),
    THREE_WHEEL_PARKING("three_wheeler_parking"),

    FOUR_WHEEL_PARKING("four_wheeler_parking");

    private final String value;
    private ParkingType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
