package problems.elevator_system.model;

import problems.elevator_system.enums.Direction;
import problems.elevator_system.enums.ElevatorState;

public class ElevatorCar {
    private int id;
    ElevatorDisplay display;
    InternalButton internalButtons;
    ElevatorState elevatorState;
    int currentFloor;
    Direction elevatorDirection;
    ElevatorDoor elevatorDoor;


    public ElevatorCar(){
        display = new ElevatorDisplay();
        internalButtons = new InternalButton();
        elevatorState = ElevatorState.IDLE;
        currentFloor = 0;
        elevatorDirection = Direction.UP;
        elevatorDoor = new ElevatorDoor();

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void showDisplay() {
        display.showDisplay();
    }

    public void pressButton(int destination) {
        internalButtons.submitRequest(destination, this);
    }

    public void setDisplay() {
        this.display.setDisplay(currentFloor, elevatorDirection);
    }
    boolean moveElevator(Direction dir, int destinationFloor){
        int startFloor = currentFloor;
        if(dir == Direction.UP) {
            for(int i = startFloor; i<=destinationFloor; i++) {

                this.currentFloor = startFloor;
                setDisplay();
                showDisplay();
                if(i == destinationFloor) {
                    return true;
                }
            }
        }

        if(dir == Direction.DOWN) {
            for(int i = startFloor; i>=destinationFloor; i--) {

                this.currentFloor = startFloor;
                setDisplay();
                showDisplay();
                if(i == destinationFloor) {
                    return true;
                }
            }
        }
        return false;
    }

    public ElevatorDisplay getDisplay() {
        return display;
    }

    public void setDisplay(ElevatorDisplay display) {
        this.display = display;
    }

    public InternalButton getInternalButtons() {
        return internalButtons;
    }

    public void setInternalButtons(InternalButton internalButtons) {
        this.internalButtons = internalButtons;
    }

    public ElevatorState getElevatorState() {
        return elevatorState;
    }

    public void setElevatorState(ElevatorState elevatorState) {
        this.elevatorState = elevatorState;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public Direction getElevatorDirection() {
        return elevatorDirection;
    }

    public void setElevatorDirection(Direction elevatorDirection) {
        this.elevatorDirection = elevatorDirection;
    }

    public ElevatorDoor getElevatorDoor() {
        return elevatorDoor;
    }

    public void setElevatorDoor(ElevatorDoor elevatorDoor) {
        this.elevatorDoor = elevatorDoor;
    }
}
