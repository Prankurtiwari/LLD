package Behavioural_Design_Pattern.StrategyPattern.with;

import Behavioural_Design_Pattern.StrategyPattern.with.Strategy.SportsDriveStrategy;

public class OffRoadVehicle extends Vehicle {
    OffRoadVehicle() {
        super(new SportsDriveStrategy());
    }
}
