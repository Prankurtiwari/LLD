package Behavioural_Design_Pattern.StrategyPattern.with;

import Behavioural_Design_Pattern.StrategyPattern.with.Strategy.NormalDriveStrategy;

public class PassengerVehicle extends Vehicle {

    PassengerVehicle() {
        super(new NormalDriveStrategy());
    }
}
