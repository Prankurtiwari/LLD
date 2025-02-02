package problems.elevator_system.seeders;

import problems.elevator_system.controllers.LookElevatorController;
import problems.elevator_system.model.ElevatorCar;
import problems.elevator_system.strategy.LookStrategy;
import problems.elevator_system.strategy.OddEvenStrategy;

import java.util.*;

public class ElevatorCreator {
    public static List<LookElevatorController> lookElevatorControllerList = new ArrayList<>();

    static {

        ElevatorCar elevatorCar1 = new ElevatorCar();
        elevatorCar1.setId(1);
        LookElevatorController controller1 = new LookElevatorController(elevatorCar1);

        ElevatorCar elevatorCar2 = new ElevatorCar();
        elevatorCar1.setId(2);
        LookElevatorController controller2 = new LookElevatorController(elevatorCar2);

        lookElevatorControllerList.add(controller1);
        lookElevatorControllerList.add(controller2);
    }

}
