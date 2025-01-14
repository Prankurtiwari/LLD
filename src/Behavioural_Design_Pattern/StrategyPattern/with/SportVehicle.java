package Behavioural_Design_Pattern.StrategyPattern.with;

import Behavioural_Design_Pattern.StrategyPattern.with.Strategy.SportsDriveStrategy;

public class SportVehicle extends Vehicle {
    SportVehicle() {
        super(new SportsDriveStrategy());
    }

}
