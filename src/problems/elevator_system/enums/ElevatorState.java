package problems.elevator_system.enums;

public enum ElevatorState {
    MOVING(200), IDLE(100);
    private final int value;
    ElevatorState(int i) {
        this.value = i;
    }
    public int getValue() {
        return value;
    }
}
