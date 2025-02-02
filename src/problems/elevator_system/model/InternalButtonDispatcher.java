package problems.elevator_system.model;

import problems.elevator_system.controllers.LookElevatorController;
import problems.elevator_system.seeders.ElevatorCreator;

import java.util.List;

public class InternalButtonDispatcher {
    List<LookElevatorController> lookElevatorControllerList = ElevatorCreator.lookElevatorControllerList;

    public void submitInternalRequest (int floorNumber,  ElevatorCar elevatorCar) {

    }
}
