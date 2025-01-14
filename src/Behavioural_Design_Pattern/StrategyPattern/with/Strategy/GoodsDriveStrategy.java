package Behavioural_Design_Pattern.StrategyPattern.with.Strategy;

public class GoodsDriveStrategy implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("Goods drive");
    }
}
