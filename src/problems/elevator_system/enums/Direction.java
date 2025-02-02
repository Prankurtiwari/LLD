package problems.elevator_system.enums;

public enum Direction {
    UP(200), DOWN(100);
    private final int value;
    Direction(int i) {
        this.value = i;
    }
    public int getValue() {
        return value;
    }
}
