package Behavioural_Design_Pattern.StrategyPattern.with;

import Behavioural_Design_Pattern.StrategyPattern.with.Strategy.GoodsDriveStrategy;

public class GoodsVehicle extends Vehicle {

    GoodsVehicle() {
        super(new GoodsDriveStrategy());
    }
}
