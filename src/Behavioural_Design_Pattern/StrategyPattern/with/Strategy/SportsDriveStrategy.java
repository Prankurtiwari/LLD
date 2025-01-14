package Behavioural_Design_Pattern.StrategyPattern.with.Strategy;

public class SportsDriveStrategy implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("sports drive");
    }
}
