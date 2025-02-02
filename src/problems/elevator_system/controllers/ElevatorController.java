package problems.elevator_system.controllers;

import Behavioural_Design_Pattern.StrategyPattern.with.Strategy.DriveStrategy;
import problems.elevator_system.strategy.ElevatorStrategy;

public class ElevatorController {
    private final ElevatorStrategy elevatorStrategy;

    ElevatorController(ElevatorStrategy strategy) {
        this.elevatorStrategy = strategy;
    }
    public void submitExternalRequest () {
        elevatorStrategy.process();
    }
}
