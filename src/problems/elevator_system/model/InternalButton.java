package problems.elevator_system.model;

import problems.elevator_system.enums.Direction;

public class InternalButton {

    int[] availableButtons;
    int buttonSelected;

    ElevatorCar elevatorCar;

    private final InternalButtonDispatcher internalButtonDispatcher;


    public InternalButton() {
        this.availableButtons = new int[]{1, 2, 3, 4, 5};
        this.internalButtonDispatcher = new InternalButtonDispatcher();
    }

    public void submitRequest(int buttonSelected, ElevatorCar car) {
        //1.check if destination is in the list of available floors
        //2.submit the request to the jobDispatcher
        this.buttonSelected = buttonSelected;
        this.elevatorCar = car;
        internalButtonDispatcher.submitInternalRequest(buttonSelected, elevatorCar);

    }
}
