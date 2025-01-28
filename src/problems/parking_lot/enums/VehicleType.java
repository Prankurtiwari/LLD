package problems.parking_lot.enums;

public enum VehicleType {
    TWO_WHEEL("two_wheeler"),
    THREE_WHEEL("three_wheeler"),

    FOUR_WHEEL("four_wheeler");

    private final String value;
    private VehicleType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
