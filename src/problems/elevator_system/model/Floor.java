package problems.elevator_system.model;

import problems.elevator_system.enums.Direction;

public class Floor {
    private int floorNumber;
    private ExternalButtonDispatcher button;

    public Floor(int floorNumber) {
        this.floorNumber = floorNumber;
        this.button = new ExternalButtonDispatcher();
    }

    public void pressButton(Direction direction) {
        button.submitExternalRequest(direction, floorNumber);
    }
}
