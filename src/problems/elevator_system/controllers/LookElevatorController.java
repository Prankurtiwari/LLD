package problems.elevator_system.controllers;

import problems.elevator_system.enums.Direction;
import problems.elevator_system.model.ElevatorCar;
import problems.elevator_system.strategy.ElevatorStrategy;
import problems.elevator_system.strategy.LookStrategy;
import problems.elevator_system.strategy.OddEvenStrategy;

import java.util.PriorityQueue;

public class LookElevatorController extends ElevatorController{

    private ElevatorCar elevatorCar;
    private final PriorityQueue<Integer> upMinPQ;
    private final PriorityQueue<Integer> downMaxPQ;




    public ElevatorCar getElevatorCar() {
        return elevatorCar;
    }

    public LookElevatorController(ElevatorCar elevatorCar) {
        super(new LookStrategy());
        this.elevatorCar = elevatorCar;
        upMinPQ = new PriorityQueue<>();
        downMaxPQ = new PriorityQueue<>((a,b) -> b-a);
    }

    public void submitExternalRequest(int floorNumber, Direction direction) {
            // run code based on LookStrategy

    }

    public void submitInternalRequest(int floorNumber) {
        // run code based on LookStrategy
    }

    public void controlElevator() {
        while(true) {
            if(elevatorCar.getElevatorDirection() == Direction.UP){

            }
        }
    }
}
