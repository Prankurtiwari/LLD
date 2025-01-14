package Behavioural_Design_Pattern.StrategyPattern.with;

import Behavioural_Design_Pattern.StrategyPattern.with.Strategy.DriveStrategy;

public class Vehicle {
     private final DriveStrategy driveStrategy;

     Vehicle(DriveStrategy strategy) {
         this.driveStrategy = strategy;
     }
    public void drive () {
        driveStrategy.drive();
    }
}
