package problems.elevator_system.model;

import problems.elevator_system.controllers.LookElevatorController;
import problems.elevator_system.enums.Direction;
import problems.elevator_system.seeders.ElevatorCreator;
import problems.elevator_system.strategy.LookStrategy;
import problems.elevator_system.strategy.OddEvenStrategy;

import java.util.List;

public class ExternalButtonDispatcher {
    List<LookElevatorController> lookElevatorControllerList = ElevatorCreator.lookElevatorControllerList;

    public void submitExternalRequest(Direction direction, int floorNumber) {
        // for simplicity, following even odd
        for (LookElevatorController lookElevatorController : lookElevatorControllerList) {
            int id = lookElevatorController.getElevatorCar().getId();
            if (id % 2 == 1 && floorNumber % 2 == 1) {
                lookElevatorController.submitExternalRequest(floorNumber, direction);
            } else if (id % 2 == 0 && floorNumber % 2 == 0) {
                lookElevatorController.submitExternalRequest(floorNumber, direction);
            }
        }
    }
}
